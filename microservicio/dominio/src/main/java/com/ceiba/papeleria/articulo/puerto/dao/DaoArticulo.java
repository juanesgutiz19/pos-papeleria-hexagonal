package com.ceiba.papeleria.articulo.puerto.dao;

import com.ceiba.papeleria.articulo.modelo.dto.ArticuloDTO;

import java.util.List;

public interface DaoArticulo {

    List<ArticuloDTO> obtenerArticulosPorNombre(String nombre);

}
