package co.com.hemisferiod.app.facturacion.services;

import java.util.List;

import co.com.hemisferiod.app.facturacion.entitys.Detalle;

public interface IDetalleService {
	
	public List<Detalle> findAll();
	public Detalle findById(Integer id);
	
}
