package com.ceiba.papeleria.inventario.servicio;

import com.ceiba.papeleria.dominio.ValidadorArgumento;
import com.ceiba.papeleria.inventario.modelo.entidad.Inventario;
import com.ceiba.papeleria.inventario.puerto.repositorio.RepositorioInventario;

public class ServicioActualizarCantidadDisponible {

    private static final String MENSAJE_REGISTRO_INVENTARIO_NO_EXISTE = "No existe registro de inventario asociado al código del artículo enviado";

    private final RepositorioInventario repositorioInventario;

    public ServicioActualizarCantidadDisponible(RepositorioInventario repositorioInventario) {
        this.repositorioInventario = repositorioInventario;
    }

    public void ejecutar(Inventario inventario, Integer cantidadAAgregar) {
        ValidadorArgumento.validarObligatorio(inventario, MENSAJE_REGISTRO_INVENTARIO_NO_EXISTE);
        inventario.actualizarCantidadDisponible(cantidadAAgregar);
        repositorioInventario.actualizarCantidadDisponibleArticulo(inventario);
    }

}