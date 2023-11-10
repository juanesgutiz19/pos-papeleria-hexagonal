package com.ceiba.papeleria.venta.servicio;

import com.ceiba.papeleria.venta.modelo.entidad.SolicitudRegistrar;
import com.ceiba.papeleria.venta.modelo.entidad.Venta;
import com.ceiba.papeleria.venta.puerto.repositorio.RepositorioVenta;

public class ServicioRegistrar {

    private final RepositorioVenta repositorioVenta;

    public ServicioRegistrar(RepositorioVenta repositorioVenta) {
        this.repositorioVenta = repositorioVenta;
    }

    public Long ejecutar(SolicitudRegistrar solicitudRegistrar){
        Venta venta = Venta.crear(solicitudRegistrar);
        return repositorioVenta.guardar(venta);
    }
}
