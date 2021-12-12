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

import co.com.hemisferiod.app.facturacion.entitys.Cliente;
import co.com.hemisferiod.app.facturacion.services.IClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	/**
	 * Atributo inyectado para acceder a los servicios de la fachada donde se accede a la base de datos.
	 */
	@Autowired
	private IClienteService clienteService;
	
	/***
	 * Api REST para listar todos los clientes de la base de datos.
	 * @return Respuesta con la lista de clientes o un mensaje de error y su status correspondiente. 
	 */
	@GetMapping("/listar")
	public ResponseEntity<?> listarClientes(){
		ResponseEntity<?> respuesta = new ResponseEntity<>(
				"No hay ningun cliente registrado", 
				HttpStatus.NOT_FOUND);
		List<Cliente> listaClientes = clienteService.findAll();
		if (!listaClientes.isEmpty()) {
			respuesta = new ResponseEntity<>(listaClientes, HttpStatus.OK);
		}
		return respuesta;
	}
	
	/**
	 * Api REST para buscar un cliente por medio de su identificacion.
	 * @param id: identificacion del cliente para agregar al criterio de busqueda.
	 * @return Respuesta con el cliente buscado o un mensaje de error y su status correspondiente.
	 */
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarCliente(@PathVariable Integer id){
		ResponseEntity<?> respuesta = new ResponseEntity<>(
				"No se encontro ningun cliente con ese identificador", 
				HttpStatus.NOT_FOUND);
		Cliente cliente = clienteService.findById(id);
		if (cliente != null) {
			respuesta = new ResponseEntity<>(cliente, HttpStatus.OK);
		}
		return respuesta;
	}
	
	/**
	 * Api REST para registrar un cliente.
	 * @param cliente: Informacion del cliente que se quiere registrar.
	 * @return Respuesta con el cliente creado correctamente o un mensaje de error y su status correspondiente.
	 */
	@PostMapping("/registrar")
	public ResponseEntity<?> registrarCliente(@RequestBody Cliente cliente){
		ResponseEntity<?> respuesta = new ResponseEntity<>(
				"No se pudo registrar el cliente, por favor revise la peticion", 
				HttpStatus.NOT_FOUND);
		Cliente refCliente = clienteService.save(cliente);
		if (refCliente != null) {
			respuesta = new ResponseEntity<>(refCliente, HttpStatus.CREATED);
		}
		return respuesta;
	}
	
}
