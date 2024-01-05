package com.ceiba.papeleria.inventario.controlador.testdatabuilder;

import com.ceiba.papeleria.inventario.comando.ComandoActualizarCantidadDisponible;

public class ComandoActualizarCantidadDisponibleTestDataBuilder {

    private String idArticulo;
    private Integer cantidad;

    public ComandoActualizarCantidadDisponibleTestDataBuilder crearPorDefecto() {
        this.idArticulo = "CUA001";
        this.cantidad = 2;
        return this;
    }

    public ComandoActualizarCantidadDisponibleTestDataBuilder conIdArticulo(String idArticulo){
        this.idArticulo = idArticulo;
        return this;
    }

    public ComandoActualizarCantidadDisponibleTestDataBuilder conCantidad(Integer cantidad){
        this.cantidad = cantidad;
        return this;
    }

    public ComandoActualizarCantidadDisponible build() {
        return new ComandoActualizarCantidadDisponible(idArticulo, cantidad);
    }

}
