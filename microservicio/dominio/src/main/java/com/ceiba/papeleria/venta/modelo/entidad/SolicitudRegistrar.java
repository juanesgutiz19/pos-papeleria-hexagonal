package com.ceiba.papeleria.venta.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class SolicitudRegistrar {
    private final LocalDate fecha;
    private final List<DetalleVenta> detallesVenta;
}
