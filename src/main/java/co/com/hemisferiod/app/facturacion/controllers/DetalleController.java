package co.com.hemisferiod.app.facturacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.hemisferiod.app.facturacion.entitys.Detalle;
import co.com.hemisferiod.app.facturacion.services.IDetalleService;

@RestController
@RequestMapping("/api/detalle")
public class DetalleController {
	
	/**
	 * Atributo inyectado para acceder a los servicios de la fachada donde se accede a la base de datos.
	 */
	@Autowired
	private IDetalleService serviceDetalle;
	
	/**
	 * Api REST para listar todos los detalles de la base de datos.
	 * @return Respuesta con la lista de detalles o un mensaje de error y su status correspondiente.
	 */
	@GetMapping("/listar")
	public ResponseEntity<?> listarDetalles(){
		ResponseEntity<?> respuesta = new ResponseEntity<>(
				"No hay ningun detalle registrado", 
				HttpStatus.NOT_FOUND);
		List<Detalle> listaDetalles = serviceDetalle.findAll();
		if (!listaDetalles.isEmpty()) {
			respuesta = new ResponseEntity<>(listaDetalles, HttpStatus.OK);
		}
		return respuesta;
	}
	
	/**
	 * Api REST para buscar un detalle por medio de su ID.
	 * @param id: ID del detalle para agregar al criterio de busqueda.
	 * @return Respuesta con el detalle buscado o un mensaje de error y su status correspondiente.
	 */
	@GetMapping("/buscar/{codigo}")
	public ResponseEntity<?> buscarProducto(@PathVariable Integer id){
		ResponseEntity<?> respuesta = new ResponseEntity<>(
				"No se encontro ningun producto con ese codigo", 
				HttpStatus.NOT_FOUND);
		Detalle detalle = serviceDetalle.findById(id);
		if (detalle != null) {
			respuesta = new ResponseEntity<>(detalle, HttpStatus.OK);
		}
		return respuesta;
	}

}
