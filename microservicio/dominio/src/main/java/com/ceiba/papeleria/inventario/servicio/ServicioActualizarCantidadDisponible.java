package com.ceiba.papeleria.inventario.servicio;

import com.ceiba.papeleria.dominio.ValidadorArgumento;
import com.ceiba.papeleria.inventario.modelo.entidad.Inventario;
import com.ceiba.papeleria.inventario.puerto.repositorio.RepositorioInventario;

public class ServicioActualizarCantidadDisponible {

    private final RepositorioInventario repositorioInventario;

    public ServicioActualizarCantidadDisponible(RepositorioInventario repositorioInventario) {
        this.repositorioInventario = repositorioInventario;
    }

    public void ejecutar(Inventario inventario, Integer cantidadAAgregar) {
        ValidadorArgumento.validarObligatorio(inventario, "No existe registro de inventario asociado al código del artículo enviado");
        inventario.actualizarCantidadDisponible(cantidadAAgregar);
        repositorioInventario.actualizarCantidadDisponibleArticulo(inventario);
    }

}
