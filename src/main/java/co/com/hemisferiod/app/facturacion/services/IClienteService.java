package co.com.hemisferiod.app.facturacion.services;

import java.util.List;

import co.com.hemisferiod.app.facturacion.entitys.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
	public Cliente findById(Integer id);
	public Cliente save(Cliente cliente);

}
