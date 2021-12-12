package co.com.hemisferiod.app.facturacion.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detalles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Detalle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@JoinColumn(name = "id_detalle")
	private Integer idDetalle;
	
//	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = false)
	private Producto refProducto;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_factura", nullable = false)
	private Factura refFactura;
	
	@Column(nullable = false)
	private Integer cantidad;
	
}
