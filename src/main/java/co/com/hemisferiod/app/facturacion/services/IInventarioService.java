package co.com.hemisferiod.app.facturacion.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import co.com.hemisferiod.app.facturacion.entitys.Detalle;
import co.com.hemisferiod.app.facturacion.entitys.Inventario;

public interface IInventarioService {
	
	public List<Inventario> findAll();
	public Inventario findById(Integer id);
	public ResponseEntity<?> save(Inventario inventario, Integer id);
	public List<Detalle> validarInventario(List<Detalle> detalles);
	
}
