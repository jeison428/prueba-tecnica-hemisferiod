package co.com.hemisferiod.app.facturacion.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.hemisferiod.app.facturacion.entitys.Detalle;

@Repository
public interface DetalleDAO extends JpaRepository<Detalle, Integer> {
	
}
