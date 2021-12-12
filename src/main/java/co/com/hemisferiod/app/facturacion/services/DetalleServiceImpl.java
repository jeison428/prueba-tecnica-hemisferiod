package co.com.hemisferiod.app.facturacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.hemisferiod.app.facturacion.dao.DetalleDAO;
import co.com.hemisferiod.app.facturacion.entitys.Detalle;

@Service
@Transactional
public class DetalleServiceImpl implements IDetalleService {
	
	@Autowired
	private DetalleDAO detalleDao;

	@Override
	@Transactional(readOnly = true)
	public List<Detalle> findAll() {
		return detalleDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Detalle findById(Integer id) {
		return detalleDao.findById(id).orElse(null);
	}


}
