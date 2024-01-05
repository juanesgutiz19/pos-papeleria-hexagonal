package com.ceiba.papeleria.venta.modelo.entidad;

import com.ceiba.papeleria.dominio.ValidadorArgumento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Venta {

    private static final String ID_VENTA_OBLIGATORIO = "El id de la venta es obligatorio";
    private static final String FECHA_VENTA_OBLIGATORIA = "La fecha de la venta es obligatoria";
    private static final String TOTAL_VENTA_OBLIGATORIO = "El total de la venta es obligatorio";
    private static final String PORCENTAJE_DESCUENTO_OBLIGATORIO = "El porcentaje de descuento aplicado de la venta es obligatorio";
    private static final String DETALLES_VENTA_OBLIGATORIOS = "Los detalles de la venta son obligatorios";
    private static final String DETALLES_VENTA_NO_VACIOS = "Los detalles de la venta no pueden estar vacíos";

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
        ValidadorArgumento.validarObligatorio(solicitudRegistrar.getFecha(), FECHA_VENTA_OBLIGATORIA);
        ValidadorArgumento.validarNoVacio(solicitudRegistrar.getDetallesVenta(), DETALLES_VENTA_OBLIGATORIOS);
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
        ValidadorArgumento.validarObligatorio(id, ID_VENTA_OBLIGATORIO);
        ValidadorArgumento.validarObligatorio(fecha, FECHA_VENTA_OBLIGATORIA);
        ValidadorArgumento.validarObligatorio(total, TOTAL_VENTA_OBLIGATORIO);
        ValidadorArgumento.validarObligatorio(porcentajeDescuentoAplicadoVentas, PORCENTAJE_DESCUENTO_OBLIGATORIO);
        ValidadorArgumento.validarObligatorio(detallesVenta, DETALLES_VENTA_OBLIGATORIOS);
        ValidadorArgumento.validarNoVacio(detallesVenta, DETALLES_VENTA_NO_VACIOS);
        return new Venta(id, detallesVenta, fecha, total, porcentajeDescuentoAplicadoVentas);
    }
}