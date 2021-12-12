package co.com.hemisferiod.app.facturacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.hemisferiod.app.facturacion.dao.ProductoDAO;
import co.com.hemisferiod.app.facturacion.entitys.Inventario;
import co.com.hemisferiod.app.facturacion.entitys.Producto;

@Service
@Transactional
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	private ProductoDAO productoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findByCodigo(String codigo) {
		return productoDao.findByCodigo(codigo);
	}

	@Override
	public Producto save(Producto producto, Integer cantidad) {
		Producto newProducto = new Producto();
		newProducto.setCodigo(producto.getCodigo());
		newProducto.setNombre(producto.getNombre());
		newProducto.setTipoProducto(producto.getTipoProducto());
		newProducto.setMarca(producto.getMarca());
		newProducto.setPrecio(producto.getPrecio());
		
		Inventario inven = new Inventario();
		inven.setCantidadStock(cantidad);
		inven.setRefProducto(newProducto);
		
		newProducto.setRefInventario(inven);
		return productoDao.save(newProducto);
	}

	@Override
	public Producto findById(Integer id) {
		return productoDao.findById(id).orElse(null);
	}

}
