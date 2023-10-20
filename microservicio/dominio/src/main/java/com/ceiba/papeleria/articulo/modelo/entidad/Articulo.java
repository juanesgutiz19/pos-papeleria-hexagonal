package com.ceiba.papeleria.articulo.modelo.entidad;

import com.ceiba.papeleria.categoria.modelo.entidad.Categoria;

import java.math.BigDecimal;


public final class Articulo {

    private String codigo;
    private String nombre;
    private BigDecimal precioCompra;
    private BigDecimal precioVenta;
    private Categoria categoria;

    private Articulo(String codigo, String nombre, BigDecimal precioCompra, BigDecimal precioVenta, Categoria categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

}
