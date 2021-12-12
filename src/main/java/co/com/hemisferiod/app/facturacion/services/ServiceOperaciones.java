package co.com.hemisferiod.app.facturacion.services;

import java.util.List;

import co.com.hemisferiod.app.facturacion.entitys.Detalle;

public class ServiceOperaciones {
	
	public static Double sumarDetalles(List<Detalle> detalles) {
		Double resultado = 0.0;
		for (Detalle det : detalles) {
			resultado += det.getRefProducto().getPrecio()*det.getCantidad();
		}
		return resultado;
	}

}
