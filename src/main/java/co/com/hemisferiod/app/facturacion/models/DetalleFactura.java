package co.com.hemisferiod.app.facturacion.models;

import java.io.Serializable;
import java.util.List;

import co.com.hemisferiod.app.facturacion.entitys.Detalle;
import co.com.hemisferiod.app.facturacion.entitys.Factura;
import lombok.Data;

@Data
public class DetalleFactura implements Serializable{
	
	private Factura refFactura;
	
	private List<Detalle> refDetalles;
	
	/**
	 * para quitar el warning por la implementacion de serializable
	 */
	private static final long serialVersionUID = -7013699164432747246L;
}
