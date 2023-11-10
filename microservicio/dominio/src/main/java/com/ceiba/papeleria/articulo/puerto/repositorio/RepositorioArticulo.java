package com.ceiba.papeleria.articulo.puerto.repositorio;

import com.ceiba.papeleria.articulo.modelo.entidad.Articulo;

public interface RepositorioArticulo {

    Articulo obtener(String codigo);
}
