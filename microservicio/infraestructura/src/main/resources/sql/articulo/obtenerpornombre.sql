SELECT codigo, nombre, precio_compra, precio_venta
FROM articulo
WHERE nombre LIKE CONCAT('%', :nombre, '%');