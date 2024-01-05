package com.ceiba.papeleria.articulo.modelo.entidad;

import com.ceiba.papeleria.categoria.modelo.entidad.Categoria;
import com.ceiba.papeleria.dominio.ValidadorArgumento;
import com.ceiba.papeleria.dominio.excepcion.ExcepcionValorInvalido;

import java.math.BigDecimal;

public final class Articulo {
    private static final String CATEGORIA_ES_OBLIGATORIA = "La categoría del artículo es obligatoria";
    private static final String CODIGO_DE_ARTICULO_ES_OBLIGATORIO = "El código del artículo es obligatorio";
    private static final String NOMBRE_DE_ARTICULO_ES_OBLIGATORIO = "El nombre del artículo es obligatorio";
    private static final String PRECIO_COMPRA_ES_OBLIGATORIO = "El precio de compra del artículo es obligatorio";
    private static final String PRECIO_VENTA_ES_OBLIGATORIO = "El precio de venta del artículo es obligatorio";
    private static final String ERROR_PRECIOS_MENORES_O_IGUALES_A_CERO = "Ni el precio de compra ni el precio de venta pueden ser menores o iguales a cero";
    private static final String ERROR_PRECIO_VENTA_MENOR_A_PRECIO_COMPRA = "El precio de venta debe ser mayor al precio de compra";

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

    public static Articulo reconstruir(String codigo, String nombre, BigDecimal precioCompra, BigDecimal precioVenta) {
        validarArgumentos(codigo, nombre, precioCompra, precioVenta);

        return new Articulo(codigo, nombre, precioCompra, precioVenta, null);
    }

    public static Articulo reconstruir(String codigo, String nombre, BigDecimal precioCompra, BigDecimal precioVenta, Categoria categoria) {
        validarArgumentos(codigo, nombre, precioCompra, precioVenta);
        ValidadorArgumento.validarObligatorio(categoria, CATEGORIA_ES_OBLIGATORIA);

        return new Articulo(codigo, nombre, precioCompra, precioVenta, categoria);
    }

    private static void validarArgumentos(String codigo, String nombre, BigDecimal precioCompra, BigDecimal precioVenta) {
        ValidadorArgumento.validarObligatorio(codigo, CODIGO_DE_ARTICULO_ES_OBLIGATORIO);
        ValidadorArgumento.validarObligatorio(nombre, NOMBRE_DE_ARTICULO_ES_OBLIGATORIO);
        ValidadorArgumento.validarObligatorio(precioCompra, PRECIO_COMPRA_ES_OBLIGATORIO);
        ValidadorArgumento.validarObligatorio(precioVenta, PRECIO_VENTA_ES_OBLIGATORIO);

        if (precioVenta.compareTo(BigDecimal.ZERO) <= 0 || precioCompra.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ExcepcionValorInvalido(ERROR_PRECIOS_MENORES_O_IGUALES_A_CERO);
        }

        if (precioVenta.compareTo(precioCompra) <= 0) {
            throw new ExcepcionValorInvalido(ERROR_PRECIO_VENTA_MENOR_A_PRECIO_COMPRA);
        }
    }
}