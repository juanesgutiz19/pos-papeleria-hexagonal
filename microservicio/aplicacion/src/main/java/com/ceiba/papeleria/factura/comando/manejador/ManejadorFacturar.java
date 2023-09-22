package com.ceiba.papeleria.factura.comando.manejador;

import com.ceiba.papeleria.ComandoRespuesta;
import com.ceiba.papeleria.factura.comando.ComandoSolicitudFacturar;
import com.ceiba.papeleria.factura.comando.fabrica.FabricaSolicitudFacturar;
import com.ceiba.papeleria.factura.servicio.ServicioFacturar;
import com.ceiba.papeleria.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorFacturar implements ManejadorComandoRespuesta<ComandoSolicitudFacturar, ComandoRespuesta<Long>> {

    private final FabricaSolicitudFacturar fabricaSolicitudFacturar;
    private final ServicioFacturar servicioFacturar;

    public ManejadorFacturar(FabricaSolicitudFacturar fabricaSolicitudFacturar, ServicioFacturar servicioFacturar) {
        this.fabricaSolicitudFacturar = fabricaSolicitudFacturar;
        this.servicioFacturar = servicioFacturar;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudFacturar comandoSolicitudFacturar) {
        return new ComandoRespuesta<>(servicioFacturar
                .ejecutar(fabricaSolicitudFacturar.crear(comandoSolicitudFacturar)));
    }
}
