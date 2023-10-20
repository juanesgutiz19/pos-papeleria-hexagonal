insert into cliente(id, nombre, tipo_cliente) values(1,'Cliente 1','PREFERENCIAL');
insert into cliente(id, nombre, tipo_cliente) values(2,'Cliente 2','COMUN');
insert into producto(id, nombre, aplica_iva, valor) values(1,'Producto 1',1, 25000);
insert into producto(id, nombre, aplica_iva, valor) values(2,'Producto 2',0, 10000);

insert into factura(id_cliente, valor_total, estado ) values(1, 25000, 'ACTIVA');
insert into factura(id_cliente, valor_total, estado ) values(2, 3000, 'ANULADA');
insert into producto_facturar( id_factura, id_producto, cantidad ) values(1, 1, 2);

INSERT INTO categoria (descripcion)
VALUES ('Cuadernos'),
       ('Lápices');

INSERT INTO articulo (codigo, nombre, precio_compra, precio_venta, id_categoria)
VALUES ('CUA001', 'Cuaderno Espiral Rayado', 2000.00, 2500.00, 3),
       ('CUA002', 'Cuaderno Cuadriculado Grande', 3100.00, 4000.00, 3),
       ('LAP001', 'Lápiz HB Staedtler', 1200.00, 2000.00, 4),
       ('LAP002', 'Lápiz de Colores Faber-Castell', 1000.00, 1800.00, 4);

INSERT INTO inventario (id_articulo, cantidad_disponible, fecha_entrada)
VALUES ('CUA001', 2, '2023-10-12'),
       ('CUA002', 3, '2023-10-12'),
       ('LAP001', 5, '2023-10-12'),
       ('LAP002', 1, '2023-10-12');