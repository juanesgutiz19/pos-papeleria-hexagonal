package com.ceiba.papeleria.factura.puerto.repositorio;

import com.ceiba.papeleria.factura.modelo.entidad.Factura;

public interface RepositorioFactura {
    Long guardar(Factura factura);
    Factura obtener(Long id);
    void actualizarEstado(Factura factura);
}
