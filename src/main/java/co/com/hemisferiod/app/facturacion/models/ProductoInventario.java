package co.com.hemisferiod.app.facturacion.models;

import java.io.Serializable;

import co.com.hemisferiod.app.facturacion.entitys.Producto;
import lombok.Data;

@Data
public class ProductoInventario implements Serializable {
	
	private Producto producto;
	
	private Integer cantidad;
	
	/**
	 * para quitar el warning por la implementacion de serializable
	 */
	private static final long serialVersionUID = -7013699164432747246L;

}
