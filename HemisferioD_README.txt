La base de datos esta configurada con MySQL de esta forma:

	Nombre: prueba-hemisferiod
	Username: root
	Password: 


PRODUCTO	
	REGISTRAR PRODUCTO
	Registra la informacion de un producto en la base de datos, se debe enviar la cantidad inicial de productos para el inventario en la URL de la peticion.

	URL de la peticion:
	http://localhost:8079/api/producto/registrar/{cantidad}
	Cantidad: cantidad inicial de productos que se van a registrar.

	Peticion para el metodo POST de crear producto, mediante la URL dada anteriormente:

	{
	    "codigo": "10210",
	    "nombre": "Nuevo Producto",
	    "tipoProducto": "Saludable",
	    "marca": "Natural",
	    "precio": 2500.0
	}

	LISTAR PRODUCTOS
	Lista todos los productos registrados en la base de datos.

	URL de la peticion:
	http://localhost:8079/api/producto/listar

	BUSCAR PRODUCTO POR CODIGO
	Busca un producto espesifico por medio de su codigo.

	URL de la peticion: 
	http://localhost:8079/api/producto/buscar/{codigo}

FACTURA
	REGISTRAR FACTURA
	Registra la informacion de una factura en la base de datos, se debe enviar una lista de detalles en el cuerpo de la peticion y la referencia al cliente en la URL de la peticion, con esta referencia se asociara la nueva factura con el cliente.

	URL de la peticion:
	http://localhost:8079/api/factura/registrar/{refCliente}
	refCliente: identificacion del cliente que se va a asociar a la factura.

	Peticion para el metodo POST de crear la factura, mediante la URL dada anteriormente:

	[
    {
         "refProducto": {
            "idProducto": 1,
            "codigo": "10201",
            "nombre": "Primer Producto",
            "tipoProducto": "Saludable",
            "marca": "Natural",
            "precio": 2000.0,
            "refInventario": {
                "idInventario": 1,
                "cantidadStock": 200
            }
        },
        "cantidad": 10
    },
    {
         "refProducto": {
            "idProducto": 2,
            "codigo": "10202",
            "nombre": "Segundo Producto",
            "tipoProducto": "Saludable",
            "marca": "Natural",
            "precio": 2000.0,
            "refInventario": null
        },
        "cantidad": 150
    }
]

	LISTAR FACTURAS
	Lista todas las facturas registradas en la base de datos.

	URL de la peticion:
	http://localhost:8079/api/factura/listar

	BUSCAR FACTURA POR ID DE FACTURA
	Busca una factura espesifica por medio de su ID.

	URL de la peticion: 
	http://localhost:8079/api/factura/buscar/{id}

CLIENTE
	REGISTRAR CLIENTE
	Registra la informacion de un cliente en la base de datos.

	URL de la peticion:
	http://localhost:8079/api/cliente/registrar

	Peticion para el metodo POST de crear cliente, mediante la URL dada anteriormente:

	{
	    "identificacion": 1111222,
	    "nombre": "Pepito",
	    "telefono": "3118882211"
	}

	LISTAR CLIENTES
	Lista todos los clientes registrados en la base de datos.

	URL de la peticion:
	http://localhost:8079/api/cliente/listar

	BUSCAR CLIENTE POR IDENTIFICACION
	Busca un cliente espesifico por medio de su identificacion.

	URL de la peticion: 
	http://localhost:8079/api/cliente/buscar/{id}

INVENTARIO
	ACTUALIZAR INVENTARIO
	Actualiza la informacion de un inventario registrado previamente en la base de datos, se debe enviar el ID del inventario en la URL de la peticion. Dado que el ID no se puede actualizar, esta API PUT solo sirve para actualizar la cantidad de stock del producto asociada a ella. Pero se debe enviar el ID del inventario tanto en el cuerpo de la peticion como en la URL de la misma.

	URL de la peticion:
	http://localhost:8079/api/inventario/actualizar/{id}
	Id: Id del inventario que se va a actualizar

	Peticion para el metodo PUT de actualizar inventario, mediante la URL dad anteriormente:

    {
        "idInventario": 4,
        "cantidadStock": 100
    }

	LISTAR INVENTARIOS
	Lista todos los inventarios registrados en la base de datos.

	URL de la peticion:
	http://localhost:8079/api/inventario/listar

	BUSCAR INVENTARIO POR ID
	Busca un inventario espesifico por medio de su ID.

	URL de la peticion: 
	http://localhost:8079/api/inventario/buscar/{id}

DETALLE
	REGISTRAR DETALLE
	En este caso no se creo la api para registrar un detalle dado que los detalles se crean cuando se crea la factura.

	LISTAR DETALLES
	Lista todos los detalles registrados en la base de datos.

	URL de la peticion:
	http://localhost:8079/api/detalle/listar

	BUSCAR DETALLE POR ID
	Busca un detalle espesifico por medio de su ID.

	URL de la peticion: 
	http://localhost:8079/api/detalle/buscar/{codigo}