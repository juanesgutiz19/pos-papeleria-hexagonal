package com.ceiba.papeleria.venta.modelo.entidad;

import com.ceiba.papeleria.articulo.modelo.entidad.Articulo;

import java.math.BigDecimal;

import static com.ceiba.papeleria.dominio.ValidadorArgumento.validarObligatorio;

public final class DetalleVenta {

    private static final String ID_DETALLE_VENTA_OBLIGATORIO = "El id del detalle de la venta es obligatorio";
    private static final String ARTICULO_DETALLE_VENTA_OBLIGATORIO = "El artículo asociado al detalle de la venta es obligatorio";
    private static final String CANTIDAD_DETALLE_VENTA_OBLIGATORIO = "La cantidad asociada al detalle de la venta es obligatoria";
    private static final String SUBTOTAL_DETALLE_VENTA_OBLIGATORIO = "El subtotal del detalle de la venta es obligatorio";
    private static final String PORCENTAJE_DESCUENTO_DETALLE_VENTA_OBLIGATORIO = "El porcentaje de descuento aplicado del detalle de la venta es obligatorio";

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

    public DetalleVenta(Articulo articulo, Integer cantidad, BigDecimal subtotal, BigDecimal porcentajeDescuentoAplicadoDetalle) {
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.porcentajeDescuentoAplicadoDetalle = porcentajeDescuentoAplicadoDetalle;
    }

    public Long getId() {
        return id;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public BigDecimal getPorcentajeDescuentoAplicadoDetalle() {
        return porcentajeDescuentoAplicadoDetalle;
    }

    public static DetalleVenta crear(Integer cantidad, Articulo articulo) {
        validarObligatorio(cantidad, CANTIDAD_DETALLE_VENTA_OBLIGATORIO);
        validarObligatorio(articulo, ARTICULO_DETALLE_VENTA_OBLIGATORIO);
        BigDecimal precioVentaArticulo = articulo.getPrecioVenta();

        return new DetalleVenta(articulo, cantidad, new BigDecimal(cantidad).multiply(precioVentaArticulo), BigDecimal.ZERO);
    }

    public static DetalleVenta reconstruir(Long id, Articulo articulo, Integer cantidad, BigDecimal subtotal, BigDecimal porcentajeDescuentoAplicadoDetalle) {
        validarObligatorio(id, ID_DETALLE_VENTA_OBLIGATORIO);
        validarObligatorio(articulo, ARTICULO_DETALLE_VENTA_OBLIGATORIO);
        validarObligatorio(cantidad, CANTIDAD_DETALLE_VENTA_OBLIGATORIO);
        validarObligatorio(subtotal, SUBTOTAL_DETALLE_VENTA_OBLIGATORIO);
        validarObligatorio(porcentajeDescuentoAplicadoDetalle, PORCENTAJE_DESCUENTO_DETALLE_VENTA_OBLIGATORIO);

        return new DetalleVenta(id, articulo, cantidad, subtotal, porcentajeDescuentoAplicadoDetalle);
    }
}