package co.com.hemisferiod.app.facturacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.hemisferiod.app.facturacion.entitys.Detalle;
import co.com.hemisferiod.app.facturacion.entitys.Factura;
import co.com.hemisferiod.app.facturacion.services.IFacturaService;

@RestController
@RequestMapping("/api/factura")
public class FacturaController {
	
	/**
	 * Atributo inyectado para acceder a los servicios de la fachada donde se accede a la base de datos.
	 */
	@Autowired
	private IFacturaService facturaService;
	
	/**
	 * Api REST para listar todas las facturas de la base de datos.
	 * @return Respuesta con la lista de facturas o un mensaje de error y su status correspondiente.
	 */
	@GetMapping("/listar")
	public ResponseEntity<?> listarFacturas(){
		ResponseEntity<?> respuesta = new ResponseEntity<>(
				"No hay ninguna factura registrada", 
				HttpStatus.NOT_FOUND);
		List<Factura> listaFacturas = facturaService.findAll();
		if (!listaFacturas.isEmpty()) {
			respuesta = new ResponseEntity<>(listaFacturas, HttpStatus.OK);
		}
		return respuesta;
	}
	
	/**
	 * Api REST para buscar una factura por medio de su ID.
	 * @param id: ID de la factura para agregar al criterio de busqueda.
	 * @return Respuesta con la factura buscada o un mensaje de error y su status correspondiente.
	 */
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarFactura(@PathVariable Integer id){
		ResponseEntity<?> respuesta = new ResponseEntity<>(
				"No se encontro ninguna factura con ese ID", 
				HttpStatus.NOT_FOUND);
		Factura factura = facturaService.findById(id);
		if (factura != null) {
			respuesta = new ResponseEntity<>(factura, HttpStatus.OK);
		}
		return respuesta;
	}
	
	/**
	 * Api REST para registrar un cliente.
	 * @param detalles: Informacion de los productos y su respectiva cantidad que se va a comprar 
	 * @param refCliente: Identificacion del cliente que va a relizar la compra 
	 * @return Respuesta con la factura creada correctamente o un mensaje de error y su status correspondiente.
	 */
	@PostMapping("/registrar/{refCliente}")
	public ResponseEntity<?> registrarCliente(@RequestBody List<Detalle> detalles, 
			@PathVariable Integer refCliente){
		ResponseEntity<?> respuesta = new ResponseEntity<>(
				"No se pudo registrar la factura, por favor revise la peticion", 
				HttpStatus.NOT_FOUND);
		Factura detalleFactura = facturaService.save(detalles, refCliente);
		if (detalleFactura != null) {
			respuesta = new ResponseEntity<>(detalleFactura, HttpStatus.CREATED);
		}
		return respuesta;
	}

}
