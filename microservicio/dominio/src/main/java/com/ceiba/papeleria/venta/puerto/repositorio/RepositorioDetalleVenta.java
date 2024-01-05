package com.ceiba.papeleria.venta.puerto.repositorio;

import com.ceiba.papeleria.venta.modelo.entidad.DetalleVenta;
import com.ceiba.papeleria.venta.modelo.entidad.Venta;

import java.util.List;

public interface RepositorioDetalleVenta {

    void guardarPorVenta(Venta venta, Long idVenta);

    List<DetalleVenta> obtenerPorVenta(Long idVenta);

    void guardar(DetalleVenta detalleVenta, Long idVenta);
}
