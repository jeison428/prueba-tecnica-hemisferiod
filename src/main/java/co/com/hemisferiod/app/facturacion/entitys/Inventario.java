package co.com.hemisferiod.app.facturacion.entitys;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inventarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JoinColumn(name = "id_inventario")
	private Long id;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "refInventario")
	private List<Producto> productos;	
	
	@JoinColumn(name = "cantidad_stock", nullable = false)
	private Long cantidadStock;

}
