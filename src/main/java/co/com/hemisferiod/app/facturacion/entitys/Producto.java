package co.com.hemisferiod.app.facturacion.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	private String codigo;
	
	@Column(nullable = false, length = 50)
	private String nombre;
	
	@JoinColumn(name = "tipo_producto", nullable = false)
	private String tipoProducto;
	
	@Column(nullable = false, length = 30)
	private String marca;
	
	@ManyToOne
	@JoinColumn(name = "id_inventario")
	private Inventario refInventario;

}
