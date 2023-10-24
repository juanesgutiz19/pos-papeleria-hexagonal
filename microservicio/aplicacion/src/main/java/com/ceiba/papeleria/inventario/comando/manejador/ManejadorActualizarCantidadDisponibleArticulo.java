package com.ceiba.papeleria.inventario.comando.manejador;

import com.ceiba.papeleria.inventario.comando.ComandoActualizarCantidadDisponible;
import com.ceiba.papeleria.inventario.puerto.repositorio.RepositorioInventario;
import com.ceiba.papeleria.inventario.servicio.ServicioActualizarCantidadDisponible;
import com.ceiba.papeleria.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarCantidadDisponibleArticulo implements ManejadorComando<ComandoActualizarCantidadDisponible> {

    private final ServicioActualizarCantidadDisponible servicioActualizarCantidadDisponible;
    private final RepositorioInventario repositorioInventario;

    public ManejadorActualizarCantidadDisponibleArticulo(ServicioActualizarCantidadDisponible servicioActualizarCantidadDisponible, RepositorioInventario repositorioInventario) {
        this.servicioActualizarCantidadDisponible = servicioActualizarCantidadDisponible;
        this.repositorioInventario = repositorioInventario;
    }

    @Override
    public void ejecutar(ComandoActualizarCantidadDisponible comandoActualizarCantidadDisponible) {
        servicioActualizarCantidadDisponible.ejecutar(repositorioInventario.obtenerPorArticulo(comandoActualizarCantidadDisponible.getIdArticulo()), comandoActualizarCantidadDisponible.getCantidad());
    }
}
