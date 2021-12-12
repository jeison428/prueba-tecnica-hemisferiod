package co.com.hemisferiod.app.facturacion.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.hemisferiod.app.facturacion.entitys.Inventario;

@Repository
public interface InventarioDAO extends JpaRepository<Inventario, Integer> {
	
//	public Inventario findByRefProducto(String codigo);

}
