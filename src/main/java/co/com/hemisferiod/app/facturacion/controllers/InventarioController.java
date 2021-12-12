package co.com.hemisferiod.app.facturacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.hemisferiod.app.facturacion.entitys.Inventario;
import co.com.hemisferiod.app.facturacion.services.IInventarioService;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {
	
	/**
	 * Atributo inyectado para acceder a los servicios de la fachada donde se accede a la base de datos.
	 */
	@Autowired
	private IInventarioService inventarioService;
	
	/**
	 * Api REST para listar todos los inventarios de la base de datos.
	 * @return Respuesta con la lista de inventarios o un mensaje de error y su status correspondiente.
	 */
	@GetMapping("/listar")
	public ResponseEntity<?> listarInventario(){
		ResponseEntity<?> respuesta = new ResponseEntity<>(
				"No hay ningun inventario registrado", 
				HttpStatus.NOT_FOUND);
		List<Inventario> listaInventarios = inventarioService.findAll();
		if (!listaInventarios.isEmpty()) {
			respuesta = new ResponseEntity<>(listaInventarios, HttpStatus.OK);
		}
		return respuesta;
	}
	
	/**
	 * Api REST para buscar un inventario por medio de su ID.
	 * @param id: ID del inventario para agregar al criterio de busqueda.
	 * @return Respuesta con el inventario buscado o un mensaje de error y su status correspondiente.
	 */
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarInventario(@PathVariable Integer id){
		ResponseEntity<?> respuesta = new ResponseEntity<>(
				"No se encontro ningun inventario con ese identificador", 
				HttpStatus.NOT_FOUND);
		Inventario inventario = inventarioService.findById(id);
		if (inventario != null) {
			respuesta = new ResponseEntity<>(inventario, HttpStatus.OK);
		}
		return respuesta;
	}
	
	/**
	 * Api REST para actualizar un inventario.
	 * @param inventario: Informacion del inventario con el campos actualizado.
	 * @param id: ID del inventario que se va a actualizar.
	 * @return Respuesta con el inventario actualizado correctamente o un mensaje de error y su status correspondiente.
	 */
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> actualizarInventario(@RequestBody Inventario inventario,
			@PathVariable Integer id){
		return inventarioService.save(inventario, id);
	} 
	
}
