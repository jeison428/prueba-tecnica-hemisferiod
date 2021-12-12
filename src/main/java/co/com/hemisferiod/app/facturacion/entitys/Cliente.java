package co.com.hemisferiod.app.facturacion.entitys;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
	
	@Id
	private Integer identificacion;
	
	@Column(nullable = false)
	@JoinColumn(name = "nombre")
	private String nombre;
	
	@Column(nullable = false)
	private String telefono;

	@JsonBackReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "refCliente")
	private List<Factura> facturas;
	

}
