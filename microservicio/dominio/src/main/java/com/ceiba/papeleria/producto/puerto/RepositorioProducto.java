package com.ceiba.papeleria.producto.puerto;

import com.ceiba.papeleria.producto.entidad.Producto;

public interface RepositorioProducto {

    Producto obtener(Long id);
}
