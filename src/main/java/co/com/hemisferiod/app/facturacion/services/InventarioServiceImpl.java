package co.com.hemisferiod.app.facturacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.hemisferiod.app.facturacion.dao.InventarioDAO;
import co.com.hemisferiod.app.facturacion.entitys.Detalle;
import co.com.hemisferiod.app.facturacion.entitys.Inventario;

@Service
@Transactional
public class InventarioServiceImpl implements IInventarioService {
	
	@Autowired
	private InventarioDAO inventarioDao;
	
	@Autowired IProductoService productoService;

	@Override
	@Transactional(readOnly = true)
	public List<Inventario> findAll() {
		return inventarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Inventario findById(Integer id) {
		return inventarioDao.findById(id).orElse(null);
	}

	@Override
	public ResponseEntity<?> save(Inventario inventario, Integer id) {
		ResponseEntity<?> respuesta = null;
		if (id == inventario.getIdInventario()) {
			Inventario refInventario = this.findById(id);
			
			if (refInventario == null) {
				respuesta = new ResponseEntity<>("El Inventario con ID "+id+" no esta registrado", 
						HttpStatus.NOT_FOUND);
			}else {
				refInventario.setCantidadStock(inventario.getCantidadStock()+refInventario.getCantidadStock());		
				Inventario aux = inventarioDao.save(refInventario);
				if (aux != null) {
					respuesta = new ResponseEntity<>(aux, HttpStatus.NOT_FOUND);
				}
			}
		}else {
			respuesta = new ResponseEntity<>("El ID de la peticion no coincide con el ID del cuerpo de la peticion", 
					HttpStatus.NOT_ACCEPTABLE);
		}
		return respuesta;
	}

	@Override
	public List<Detalle> validarInventario(List<Detalle> detalles) {
		int index = 0;
		int cantidadStock = 0;
		Inventario aux = null;
		for (Detalle det : detalles) {
			if (det.getRefProducto().getRefInventario() == null) {
				det.setRefProducto(this.productoService.findByCodigo(det.getRefProducto().getCodigo()));
			}
			cantidadStock = inventarioDao.findById(det.getRefProducto().getRefInventario().getIdInventario()).orElse(null).getCantidadStock();
			if (cantidadStock <= 0) {
				detalles.remove(index);
			}else if (cantidadStock >= det.getCantidad()){
				aux = inventarioDao.findById(det.getRefProducto().getRefInventario().getIdInventario()).orElse(null);
				aux.setCantidadStock(cantidadStock - det.getCantidad());
				inventarioDao.save(aux);
			}else {
				aux = inventarioDao.findById(det.getRefProducto().getRefInventario().getIdInventario()).orElse(null);
				aux.setCantidadStock(0);
				det.setCantidad(cantidadStock);
				inventarioDao.save(aux);
			}
			index++;
		}
		return detalles;
	}
	
	

}
