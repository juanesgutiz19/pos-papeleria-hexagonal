package com.ceiba.papeleria.factura.comando.manejador;

import com.ceiba.papeleria.factura.comando.ComandoAnular;
import com.ceiba.papeleria.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.papeleria.factura.servicio.ServicioAnular;
import com.ceiba.papeleria.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorAnular implements ManejadorComando<ComandoAnular> {

    private final ServicioAnular servicioAnular;
    private final RepositorioFactura repositorioFactura;

    public ManejadorAnular(ServicioAnular servicioAnular, RepositorioFactura repositorioFactura) {
        this.servicioAnular = servicioAnular;
        this.repositorioFactura = repositorioFactura;
    }

    @Override
    public void ejecutar(ComandoAnular comandoAnular) {
        servicioAnular.ejecutar(repositorioFactura.obtener(comandoAnular.getIdFactura()));
    }
}
