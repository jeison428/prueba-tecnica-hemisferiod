package co.com.hemisferiod.app.facturacion.entitys;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "facturas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Factura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@JoinColumn(name = "id_factura")
	private Integer idFactura;
	
	@JoinColumn(name = "fecha_venta", nullable = false)
	private Date fechaVenta;
	
	@Column(nullable = false)
	private Double total;
	
	@ManyToOne
	@JoinColumn(name = "identificacion", nullable = false)
	private Cliente refCliente;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "refFactura")
	private List<Detalle> detalles;

}
