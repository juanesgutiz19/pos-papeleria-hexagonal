package com.ceiba.papeleria.venta.modelo.entidad;

import com.ceiba.papeleria.articulo.modelo.entidad.Articulo;
import com.ceiba.papeleria.dominio.ValidadorArgumento;
import com.ceiba.papeleria.factura.modelo.entidad.ProductoFacturar;
import com.ceiba.papeleria.producto.entidad.Producto;

import java.math.BigDecimal;

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
        ValidadorArgumento.validarObligatorio(cantidad, "La cantidad es requerida");
        ValidadorArgumento.validarObligatorio(articulo, "El artículo es requerido");
        BigDecimal precioVentaArticulo = articulo.getPrecioVenta();

        return new DetalleVenta(articulo, cantidad, new BigDecimal(cantidad).multiply(precioVentaArticulo), BigDecimal.ZERO);
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