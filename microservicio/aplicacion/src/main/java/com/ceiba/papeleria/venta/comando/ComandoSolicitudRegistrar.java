package com.ceiba.papeleria.venta.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudRegistrar {

    private LocalDate fecha;
    private List<ComandoDetalleVentaRegistrar> comandoDetallesVentaRegistrar;

}
