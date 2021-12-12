package co.com.hemisferiod.app.facturacion.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.hemisferiod.app.facturacion.entitys.Cliente;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Integer> {

}
