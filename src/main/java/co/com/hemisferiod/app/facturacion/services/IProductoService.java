package co.com.hemisferiod.app.facturacion.services;

import java.util.List;

import co.com.hemisferiod.app.facturacion.entitys.Producto;

public interface IProductoService {
	
	public List<Producto> findAll();
	public Producto findById(Integer id);
	public Producto findByCodigo(String codigo);
	public Producto save(Producto producto, Integer cantidad);

}
