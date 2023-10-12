-- DML --
INSERT INTO categoria (descripcion)
VALUES ('Borradores'),
       ('Bolígrafos');

INSERT INTO articulo (codigo, nombre, precio_compra, precio_venta, id_categoria)
VALUES ('BOR001', 'Borrador Pelikan PZ 40', 800.00, 1200.00, 1),
       ('BOR002', 'Borrador Nata 612', 900.00, 1500.00, 1),
       ('BOL001', 'Bolígrafo Gel Escarchado', 1500.00, 2500.00, 2),
       ('BOL002', 'Bolígrafo borrable Rocketbook', 6000.00, 8000.00, 2);

INSERT INTO inventario (id_articulo, cantidad_disponible, fecha_entrada)
VALUES ('BOR001', 5, '2023-10-12'),
       ('BOR002', 3, '2023-10-12'),
       ('BOL001', 4, '2023-10-12'),
       ('BOL002', 8, '2023-10-12');