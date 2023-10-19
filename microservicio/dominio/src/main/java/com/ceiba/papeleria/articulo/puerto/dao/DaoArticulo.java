package com.ceiba.papeleria.articulo.puerto.dao;

import com.ceiba.papeleria.articulo.modelo.dto.ArticuloDTO;
import com.ceiba.papeleria.factura.modelo.dto.ResumenFacturaDTO;

import java.util.List;

public interface DaoArticulo {

    List<ArticuloDTO> obtenerArticulosPorNombre(String nombre);

}
