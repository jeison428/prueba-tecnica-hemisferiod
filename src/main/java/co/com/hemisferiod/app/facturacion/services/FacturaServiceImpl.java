package co.com.hemisferiod.app.facturacion.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.hemisferiod.app.facturacion.dao.ClienteDAO;
import co.com.hemisferiod.app.facturacion.dao.DetalleDAO;
import co.com.hemisferiod.app.facturacion.dao.FacturaDAO;
import co.com.hemisferiod.app.facturacion.entitys.Cliente;
import co.com.hemisferiod.app.facturacion.entitys.Detalle;
import co.com.hemisferiod.app.facturacion.entitys.Factura;

@Service
@Transactional
public class FacturaServiceImpl implements IFacturaService {
	
	@Autowired
	private FacturaDAO facturaDao;
	
	@Autowired
	private ClienteDAO clienteDao;
	
	@Autowired
	private DetalleDAO detalleService;
	
	@Autowired
	private InventarioServiceImpl inventarioService;

	@Override
	@Transactional(readOnly = true)
	public List<Factura> findAll() {
		return facturaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Factura findById(Integer id) {
		return facturaDao.findById(id).orElse(null);
	}

	@Override
	public Factura save(List<Detalle> detalles, Integer refCliente) {
		Factura resultado = null;
		Cliente client = clienteDao.findById(refCliente).orElse(null);
		if (client != null) {
			Factura factura = new Factura();
			factura.setFechaVenta(new Date());
			factura.setRefCliente(client);
			detalles = inventarioService.validarInventario(detalles);
			if (detalles.isEmpty()) {
				resultado = null;
			}else {				
				factura.setTotal(ServiceOperaciones.sumarDetalles(detalles));
				this.facturaDao.save(factura);
				for (Detalle det : detalles) {
					det.setRefFactura(factura);
					detalleService.save(det);
				}
				factura.setDetalles(detalles);
				resultado = facturaDao.save(factura);
			}
		}
		return resultado;
	}
 
}
