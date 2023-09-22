package com.ceiba.papeleria.factura.servicio;

import com.ceiba.papeleria.dominio.ValidadorArgumento;
import com.ceiba.papeleria.factura.modelo.entidad.Factura;
import com.ceiba.papeleria.factura.puerto.repositorio.RepositorioFactura;

public class ServicioAnular {

    private final RepositorioFactura repositorioFactura;

    public ServicioAnular(RepositorioFactura repositorioFactura) {
        this.repositorioFactura = repositorioFactura;
    }

    public void ejecutar(Factura factura) {
        ValidadorArgumento.validarObligatorio(factura, "No existe una factura para anular");
        factura.anular();
        repositorioFactura.actualizarEstado(factura);
    }
}
