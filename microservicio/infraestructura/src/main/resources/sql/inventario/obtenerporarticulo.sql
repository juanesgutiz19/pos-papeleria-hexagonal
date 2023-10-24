select  id, cantidad_disponible, fecha_entrada
from inventario
where id_articulo = :id_articulo