
create table clientes 
(
   identificacion       int                            not null,
   nombre               varchar(50)                    null,
   telefono             varchar(12)                    null,
   constraint PK_CLIENTES primary key clustered (identificacion)
);

create table detalles 
(
   id_detalle           int                            not null AUTO_INCREMENT,
   id_producto          int                            null,
   id_factura           int                            null,
   cantidad             int                            null,
   constraint PK_DETALLES primary key clustered (id_detalle)
);

create table facturas 
(
   id_factura           int                            not null AUTO_INCREMENT,
   identificacion       int                            null,
   fecha_venta          date                           null,
   total                double                         null,
   constraint PK_FACTURAS primary key clustered (id_factura)
);

create table inventarios 
(
   id_inventario        int                            not null AUTO_INCREMENT,
   id_producto          int                            null unique,
   cantidad_stock       int                            null,
   constraint PK_INVENTARIOS primary key clustered (id_inventario)
);

create table productos 
(
   id_producto          int                            not null AUTO_INCREMENT,
   codigo               varchar(40)                    not null unique,
   nombre               varchar(50)                    null,
   tipo_producto        varchar(30)                    null,
   marca                varchar(40)                     null,
   precio               double                         null,
   constraint PK_PRODUCTOS primary key clustered (id_producto)
);

alter table detalles
   add constraint FK_DETALLES_REFERENCE_PRODUCTO foreign key (id_producto)
      references productos (id_producto)
      on update restrict
      on delete restrict;

alter table detalles
   add constraint FK_DETALLES_REFERENCE_FACTURAS foreign key (id_factura)
      references facturas (id_factura)
      on update restrict
      on delete restrict;

alter table facturas
   add constraint FK_FACTURAS_REFERENCE_CLIENTES foreign key (identificacion)
      references clientes (identificacion)
      on update restrict
      on delete restrict;

alter table inventarios
   add constraint FK_INVENTAR_REFERENCE_PRODUCTO foreign key (id_producto)
      references productos (id_producto)
      on update restrict
      on delete restrict;