package co.com.hemisferiod.app.facturacion.entitys;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;
	
	@Column(unique = true, nullable = false, updatable = false)
	private String codigo;
	
	@Column(nullable = false, length = 50)
	private String nombre;
	
	@JoinColumn(name = "tipo_producto", nullable = false)
	private String tipoProducto;
	
	@Column(nullable = false, length = 30)
	private String marca;
	
	private Double precio;
	
	@OneToOne(mappedBy = "refProducto"
			,cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
			)
	private Inventario refInventario;
	
	@JsonBackReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "refProducto")
	private List<Detalle> detalles;

}
