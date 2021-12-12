package co.com.hemisferiod.app.facturacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.hemisferiod.app.facturacion.dao.ClienteDAO;
import co.com.hemisferiod.app.facturacion.entitys.Cliente;

@Service
@Transactional
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	private ClienteDAO clienteDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Integer id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

}
