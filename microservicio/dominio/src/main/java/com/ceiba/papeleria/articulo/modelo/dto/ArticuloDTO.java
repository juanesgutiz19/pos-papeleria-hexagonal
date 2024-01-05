package com.ceiba.papeleria.articulo.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class ArticuloDTO {
    private String codigo;
    private String nombre;
    private BigDecimal precioCompra;
    private BigDecimal precioVenta;
}
