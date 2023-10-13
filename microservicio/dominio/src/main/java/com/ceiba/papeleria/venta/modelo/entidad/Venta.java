package com.ceiba.papeleria.venta.modelo.entidad;

import com.ceiba.papeleria.detalleventa.modelo.entidad.DetalleVenta;
import com.ceiba.papeleria.dominio.ValidadorArgumento;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class Venta {

    private Long id;
    private List<DetalleVenta> detallesVenta;
    private LocalDateTime fecha;
    private BigDecimal total;
    private BigDecimal porcentajeDescuentoAplicadoVentas;

    private static Venta reconstruir(Long id, List<DetalleVenta> detallesVenta, LocalDateTime fecha, BigDecimal total, BigDecimal porcentajeDescuentoAplicadoVentas) {
        ValidadorArgumento.validarObligatorio(id, "El id de la venta es obligatorio");
        ValidadorArgumento.validarObligatorio(fecha, "La fecha de la venta es obligatoria");
        ValidadorArgumento.validarObligatorio(total, "El total de la venta es obligatorio");
        ValidadorArgumento.validarObligatorio(porcentajeDescuentoAplicadoVentas, "El porcentaje de descuento aplicado de la venta es obligatorio");
        ValidadorArgumento.validarObligatorio(detallesVenta, "Los detalles de la venta son obligatorios");
        ValidadorArgumento.validarNoVacio(detallesVenta, "Los detalles de la venta no pueden estar vacíos");
        return new Venta(id, detallesVenta, fecha, total, porcentajeDescuentoAplicadoVentas);
    }
}
