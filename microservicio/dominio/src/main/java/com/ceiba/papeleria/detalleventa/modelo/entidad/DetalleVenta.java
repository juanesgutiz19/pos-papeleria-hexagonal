package com.ceiba.papeleria.detalleventa.modelo.entidad;

import com.ceiba.papeleria.articulo.modelo.entidad.Articulo;
import com.ceiba.papeleria.dominio.ValidadorArgumento;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class DetalleVenta {

    private Long id;
    private Articulo articulo;
    private Integer cantidad;
    private BigDecimal subtotal;
    private BigDecimal porcentajeDescuentoAplicadoDetalle;

    private static DetalleVenta reconstruir(Long id, Articulo articulo, Integer cantidad, BigDecimal subtotal, BigDecimal porcentajeDescuentoAplicadoDetalle) {
        ValidadorArgumento.validarObligatorio(id, "El id del detalle de la venta es obligatorio");
        ValidadorArgumento.validarObligatorio(articulo, "El artículo asociado al detalle de la venta es obligatorio");
        ValidadorArgumento.validarObligatorio(cantidad, "La cantidad asociada al detalle de la venta es obligatorio");
        ValidadorArgumento.validarObligatorio(subtotal, "El subtotal del detalle de la venta es obligatorio");
        ValidadorArgumento.validarObligatorio(porcentajeDescuentoAplicadoDetalle, "El porcentaje de cescuento aplicado del detalle de la venta es obligatorio");
        return new DetalleVenta(id, articulo, cantidad, subtotal, porcentajeDescuentoAplicadoDetalle);
    }
}
