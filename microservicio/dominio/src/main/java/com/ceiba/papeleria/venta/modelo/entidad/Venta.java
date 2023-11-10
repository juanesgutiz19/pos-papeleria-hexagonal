package com.ceiba.papeleria.venta.modelo.entidad;

import com.ceiba.papeleria.dominio.ValidadorArgumento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Venta {

    private Long id;
    private List<DetalleVenta> detallesVenta;
    private LocalDate fecha;
    private BigDecimal total;
    private BigDecimal porcentajeDescuentoAplicadoVentas;

    private Venta(Long id, List<DetalleVenta> detallesVenta, LocalDate fecha, BigDecimal total, BigDecimal porcentajeDescuentoAplicadoVentas) {
        this.id = id;
        this.detallesVenta = Collections.unmodifiableList(detallesVenta);
        this.fecha = fecha;
        this.total = total;
        this.porcentajeDescuentoAplicadoVentas = porcentajeDescuentoAplicadoVentas;
    }

    public Venta(LocalDate fecha, List<DetalleVenta> detallesVenta) {
        this.fecha = fecha;
        this.detallesVenta = new ArrayList<>(detallesVenta);
        this.porcentajeDescuentoAplicadoVentas = BigDecimal.ZERO;
        this.total = calcularTotal(detallesVenta);
    }

    public static Venta crear(SolicitudRegistrar solicitudRegistrar) {
        ValidadorArgumento.validarObligatorio(solicitudRegistrar.getFecha(), "La fecha es requerida para el registro de una venta");
        ValidadorArgumento.validarNoVacio(solicitudRegistrar.getDetallesVenta(), "No se puede registrar una venta sin detalles de venta");
        return new Venta(solicitudRegistrar.getFecha(), solicitudRegistrar.getDetallesVenta());
    }

    public Long getId() {
        return id;
    }

    public List<DetalleVenta> getDetallesVenta() {
        return detallesVenta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public BigDecimal getPorcentajeDescuentoAplicadoVentas() {
        return porcentajeDescuentoAplicadoVentas;
    }

    private BigDecimal calcularTotal(List<DetalleVenta> detallesVenta) {
        return detallesVenta.stream()
                .map(DetalleVenta::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static Venta reconstruir(Long id, List<DetalleVenta> detallesVenta, LocalDate fecha, BigDecimal total, BigDecimal porcentajeDescuentoAplicadoVentas) {
        ValidadorArgumento.validarObligatorio(id, "El id de la venta es obligatorio");
        ValidadorArgumento.validarObligatorio(fecha, "La fecha de la venta es obligatoria");
        ValidadorArgumento.validarObligatorio(total, "El total de la venta es obligatorio");
        ValidadorArgumento.validarObligatorio(porcentajeDescuentoAplicadoVentas, "El porcentaje de descuento aplicado de la venta es obligatorio");
        ValidadorArgumento.validarObligatorio(detallesVenta, "Los detalles de la venta son obligatorios");
        ValidadorArgumento.validarNoVacio(detallesVenta, "Los detalles de la venta no pueden estar vacíos");
        return new Venta(id, detallesVenta, fecha, total, porcentajeDescuentoAplicadoVentas);
    }

}
