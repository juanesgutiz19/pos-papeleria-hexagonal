package com.ceiba.papeleria.factura.modelo.dto;

import com.ceiba.papeleria.factura.modelo.entidad.EstadoFactura;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class ResumenFacturaDTO {
    private Long id;
    private BigDecimal valorTotal;
    private EstadoFactura estado;
}
