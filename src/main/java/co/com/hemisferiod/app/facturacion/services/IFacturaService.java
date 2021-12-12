package co.com.hemisferiod.app.facturacion.services;

import java.util.List;

import co.com.hemisferiod.app.facturacion.entitys.Detalle;
import co.com.hemisferiod.app.facturacion.entitys.Factura;

public interface IFacturaService {
	
	public List<Factura> findAll();
	public Factura findById(Integer id);
	/**
	 * En este metodo no se pide directamente un objeto de tipo factura ya que el atributo
	 * total de esta clase es calculado mediante el listado de objetos que se va a comprar
	 * @param
	 * detalles: lista con una referencia a producto y con la cantidad de objetos comprados
	 * refCliente: id del cleinte que va a realizar la compra
	 * @return
	 * null: Retorna null si el cliente no esta registrado o si la lista de detalles esta vacia
	 * Factura: Retorna un objeto factura con la informacion del total de ventas y el total
	 */
	public Factura save(List<Detalle> detalles, Integer refCliente);

}
