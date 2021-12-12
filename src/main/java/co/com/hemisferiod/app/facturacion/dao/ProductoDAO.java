package co.com.hemisferiod.app.facturacion.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.hemisferiod.app.facturacion.entitys.Producto;

@Repository
public interface ProductoDAO extends JpaRepository<Producto, Integer> {
	
	public Producto findByCodigo(String codigo);
}
