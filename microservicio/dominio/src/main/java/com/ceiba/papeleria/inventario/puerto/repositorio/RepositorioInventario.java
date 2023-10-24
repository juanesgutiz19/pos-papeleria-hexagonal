package com.ceiba.papeleria.inventario.puerto.repositorio;

import com.ceiba.papeleria.inventario.modelo.entidad.Inventario;

public interface RepositorioInventario {

    Inventario obtenerPorArticulo(String idArticulo);

    void actualizarCantidadDisponibleArticulo(Inventario inventario);
}
