package com.ceiba.papeleria.factura.modelo.entidad;

import com.ceiba.papeleria.cliente.entidad.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class SolicitudFacturar {

    private final Cliente cliente;
    private final List<ProductoFacturar> productosFacturar;

}
