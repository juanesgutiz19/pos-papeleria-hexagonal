package com.ceiba.papeleria.detalleventa.modelo.entidad;

import com.ceiba.papeleria.articulo.modelo.entidad.Articulo;
import com.ceiba.papeleria.dominio.ValidadorArgumento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public final class DetalleVenta {

    private Long id;
    private Articulo articulo;
    private Integer cantidad;
    private BigDecimal subtotal;
    private BigDecimal porcentajeDescuentoAplicadoDetalle;

    private DetalleVenta(Long id, Articulo articulo, Integer cantidad, BigDecimal subtotal, BigDecimal porcentajeDescuentoAplicadoDetalle) {
        this.id = id;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.porcentajeDescuentoAplicadoDetalle = porcentajeDescuentoAplicadoDetalle;
    }

    public static DetalleVenta reconstruir(Long id, Articulo articulo, Integer cantidad, BigDecimal subtotal, BigDecimal porcentajeDescuentoAplicadoDetalle) {
        ValidadorArgumento.validarObligatorio(id, "El id del detalle de la venta es obligatorio");
        ValidadorArgumento.validarObligatorio(articulo, "El artículo asociado al detalle de la venta es obligatorio");
        ValidadorArgumento.validarObligatorio(cantidad, "La cantidad asociada al detalle de la venta es obligatorio");
        ValidadorArgumento.validarObligatorio(subtotal, "El subtotal del detalle de la venta es obligatorio");
        ValidadorArgumento.validarObligatorio(porcentajeDescuentoAplicadoDetalle, "El porcentaje de cescuento aplicado del detalle de la venta es obligatorio");
        return new DetalleVenta(id, articulo, cantidad, subtotal, porcentajeDescuentoAplicadoDetalle);
    }

}
