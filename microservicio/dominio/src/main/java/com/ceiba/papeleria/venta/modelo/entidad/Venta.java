package com.ceiba.papeleria.venta.modelo.entidad;

import com.ceiba.papeleria.detalleventa.modelo.entidad.DetalleVenta;

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

}
