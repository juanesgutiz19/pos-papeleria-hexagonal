package com.ceiba.papeleria.factura.puerto.repositorio;

import com.ceiba.papeleria.factura.modelo.entidad.Factura;
import com.ceiba.papeleria.factura.modelo.entidad.ProductoFacturar;

import java.util.List;

public interface RepositorioProductoFacturar {

    void guardarPorFactura(Factura factura, Long idFactura);

    List<ProductoFacturar> obtenerPorFactura(Long idFactura);
}
