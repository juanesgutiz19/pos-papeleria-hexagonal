package com.ceiba.papeleria.venta.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoDetalleVentaRegistrar {
    private String idArticulo;
    private Integer cantidad;
}
