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

import co.com.hemisferiod.app.facturacion.entitys.Producto;
import co.com.hemisferiod.app.facturacion.services.IProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
	
	/**
	 * Atributo inyectado para acceder a los servicios de la fachada donde se accede a la base de datos.
	 */
	@Autowired
	private IProductoService productoService;
	
	/**
	 * Api REST para listar todos los productos de la base de datos
	 * @return Respuesta con la lista de productos o un mensaje de error y su status correspondiente
	 */
	@GetMapping("/listar")
	public ResponseEntity<?> listarProducto(){
		ResponseEntity<?> respuesta = new ResponseEntity<>(
				"No hay ningun producto registrado", 
				HttpStatus.NOT_FOUND);
		List<Producto> listaProductos = productoService.findAll();
		if (!listaProductos.isEmpty()) {
			respuesta = new ResponseEntity<>(listaProductos, HttpStatus.OK);
		}
		return respuesta;
	}
	
	/**
	 * Api REST para buscar un producto por medio de su codigo.
	 * @param codigo: codigo del producto que se quiere buscar.
	 * @return Respuesta con el producto buscado o un mensaje de error y su status correspondiente.
	 */
	@GetMapping("/buscar/{codigo}")
	public ResponseEntity<?> buscarProducto(@PathVariable String codigo){
		ResponseEntity<?> respuesta = new ResponseEntity<>(
				"No se encontro ningun producto con ese codigo", 
				HttpStatus.NOT_FOUND);
		Producto producto = productoService.findByCodigo(codigo);
		if (producto != null) {
			respuesta = new ResponseEntity<>(producto, HttpStatus.OK);
		}
		return respuesta;
	}
	
	/**
	 * Api REST para registrar un producto.
	 * @param producto: Informacion del producto que se quiere registrar.
	 * @param cantidad: Cantidad de productos para inicializar el inventario del mismo.
	 * @return Respuesta con el producto creado correctamente o un mensaje de error y su status correspondiente.
	 */
	@PostMapping("/registrar/{cantidad}")
	public ResponseEntity<?> registrarProducto(@RequestBody Producto producto,
			@PathVariable Integer cantidad){
		ResponseEntity<?> respuesta = new ResponseEntity<>(
								"El codigo del producto ya esta registrado", 
								HttpStatus.NOT_FOUND);
		if (productoService.findByCodigo(producto.getCodigo()) == null) {
			Producto aux = productoService.save(producto, cantidad);
			if (aux != null) {
				respuesta = new ResponseEntity<>(aux, HttpStatus.CREATED);
			}
			
		}
		return respuesta;
	}
	
}
