package com.ceiba.papeleria.detalleventa.modelo.entidad;

import com.ceiba.papeleria.articulo.modelo.entidad.Articulo;
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

}
