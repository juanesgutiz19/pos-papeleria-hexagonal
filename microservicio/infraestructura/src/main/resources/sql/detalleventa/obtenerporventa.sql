select  id, id_articulo, cantidad, subtotal, porcentaje_descuento_aplicado_detalle
from detalle_venta
where id_venta = :id_venta