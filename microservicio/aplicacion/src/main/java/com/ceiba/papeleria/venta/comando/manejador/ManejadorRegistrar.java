package com.ceiba.papeleria.venta.comando.manejador;

import com.ceiba.papeleria.ComandoRespuesta;
import com.ceiba.papeleria.manejador.ManejadorComandoRespuesta;
import com.ceiba.papeleria.venta.comando.ComandoSolicitudRegistrar;
import com.ceiba.papeleria.venta.comando.fabrica.FabricaSolicitudRegistrar;
import com.ceiba.papeleria.venta.servicio.ServicioRegistrar;
import org.springframework.stereotype.Component;

@Component
public class ManejadorRegistrar implements ManejadorComandoRespuesta<ComandoSolicitudRegistrar, ComandoRespuesta<Long>> {

    private final FabricaSolicitudRegistrar fabricaSolicitudRegistrar;
    private final ServicioRegistrar servicioRegistrar;

    public ManejadorRegistrar(FabricaSolicitudRegistrar fabricaSolicitudRegistrar, ServicioRegistrar servicioRegistrar) {
        this.fabricaSolicitudRegistrar = fabricaSolicitudRegistrar;
        this.servicioRegistrar = servicioRegistrar;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudRegistrar comandoSolicitudRegistrar) {
        return new ComandoRespuesta<>(servicioRegistrar
                .ejecutar(fabricaSolicitudRegistrar.crear(comandoSolicitudRegistrar)));
    }
}
