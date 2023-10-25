package com.ceiba.papeleria.venta.modelo.entidad;

import com.ceiba.papeleria.detalleventa.modelo.entidad.DetalleVenta;
import com.ceiba.papeleria.dominio.ValidadorArgumento;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public final class Venta {

    private Long id;
    private List<DetalleVenta> detallesVenta;
    private LocalDateTime fecha;
    private BigDecimal total;
    private BigDecimal porcentajeDescuentoAplicadoVentas;

    private Venta(Long id, List<DetalleVenta> detallesVenta, LocalDateTime fecha, BigDecimal total, BigDecimal porcentajeDescuentoAplicadoVentas) {
        this.id = id;
        this.detallesVenta = Collections.unmodifiableList(detallesVenta);
        this.fecha = fecha;
        this.total = total;
        this.porcentajeDescuentoAplicadoVentas = porcentajeDescuentoAplicadoVentas;
    }

    public Long getId() {
        return id;
    }

    public List<DetalleVenta> getDetallesVenta() {
        return detallesVenta;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public BigDecimal getPorcentajeDescuentoAplicadoVentas() {
        return porcentajeDescuentoAplicadoVentas;
    }

    public static Venta reconstruir(Long id, List<DetalleVenta> detallesVenta, LocalDateTime fecha, BigDecimal total, BigDecimal porcentajeDescuentoAplicadoVentas) {
        ValidadorArgumento.validarObligatorio(id, "El id de la venta es obligatorio");
        ValidadorArgumento.validarObligatorio(fecha, "La fecha de la venta es obligatoria");
        ValidadorArgumento.validarObligatorio(total, "El total de la venta es obligatorio");
        ValidadorArgumento.validarObligatorio(porcentajeDescuentoAplicadoVentas, "El porcentaje de descuento aplicado de la venta es obligatorio");
        ValidadorArgumento.validarObligatorio(detallesVenta, "Los detalles de la venta son obligatorios");
        ValidadorArgumento.validarNoVacio(detallesVenta, "Los detalles de la venta no pueden estar vacíos");
        return new Venta(id, detallesVenta, fecha, total, porcentajeDescuentoAplicadoVentas);
    }

}
