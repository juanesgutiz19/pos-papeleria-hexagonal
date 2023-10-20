
create table cliente (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 tipo_cliente varchar(20) not null,
 primary key (id)
);

create table producto (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 aplica_iva TINYINT not null,
 valor DECIMAL(10,2) not null,
 primary key (id)
);

create table factura (
 id int(11) not null auto_increment,
 id_cliente int(11) not null,
 valor_total DECIMAL(10,2) not null,
 estado varchar(20) not null,
 primary key (id)
);

create table producto_facturar (
 id int(11) not null auto_increment,
 id_factura int(11) not null,
 id_producto int(11) not null,
 cantidad int(11) not null,
 primary key (id)
);

ALTER TABLE factura
ADD CONSTRAINT cliente_fk
  FOREIGN KEY (id_cliente)
  REFERENCES cliente (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE producto_facturar
ADD CONSTRAINT producto_fk
  FOREIGN KEY (id_producto)
  REFERENCES producto (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE producto_facturar
ADD CONSTRAINT factura_fk
  FOREIGN KEY (id_factura)
  REFERENCES factura (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;






-- DDL --
CREATE TABLE categoria
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(80) NOT NULL
);

CREATE TABLE articulo
(
    codigo VARCHAR(6) PRIMARY KEY,
    nombre VARCHAR(60) NOT NULL,
    precio_compra DECIMAL(10, 2) NOT NULL,
    precio_venta DECIMAL(10, 2) NOT NULL,
    id_categoria INT NOT NULL,
    FOREIGN KEY (id_categoria)
        REFERENCES categoria (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);

CREATE TABLE inventario
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_articulo VARCHAR(6) NOT NULL,
    cantidad_disponible INT NOT NULL,
    fecha_entrada DATE NOT NULL,
    FOREIGN KEY (id_articulo)
        REFERENCES articulo (codigo)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);

CREATE TABLE venta
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha TIMESTAMP NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    porcentaje_descuento_aplicado_venta DECIMAL(5, 2) NOT NULL
);

CREATE TABLE detalle_venta
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_venta INT NOT NULL,
    id_articulo VARCHAR(6) NOT NULL,
    cantidad INT NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,
    porcentaje_descuento_aplicado_detalle DECIMAL(5, 2) NOT NULL,
    FOREIGN KEY (id_venta)
        REFERENCES venta (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    FOREIGN KEY (id_articulo)
        REFERENCES articulo (codigo)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);