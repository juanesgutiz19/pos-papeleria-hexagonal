package com.ceiba.papeleria.factura.servicio;

import com.ceiba.papeleria.factura.modelo.entidad.Factura;
import com.ceiba.papeleria.factura.modelo.entidad.SolicitudFacturar;
import com.ceiba.papeleria.factura.puerto.repositorio.RepositorioFactura;

public class ServicioFacturar {
    private final RepositorioFactura repositorioFactura;

    public ServicioFacturar(RepositorioFactura repositorioFactura) {
        this.repositorioFactura = repositorioFactura;
    }

    public Long ejecutar(SolicitudFacturar solicitudFacturar) {
        Factura factura = Factura.crear(solicitudFacturar);
        return repositorioFactura.guardar(factura);
    }
}
