package com.ceiba.papeleria.articulo;

import com.ceiba.papeleria.articulo.modelo.entidad.Articulo;
import com.ceiba.papeleria.categoria.CategoriaTestDataBuilder;
import com.ceiba.papeleria.categoria.modelo.entidad.Categoria;

import java.math.BigDecimal;

public class ArticuloTestDataBuilder {

    private String codigo;
    private String nombre;
    private BigDecimal precioCompra;
    private BigDecimal precioVenta;
    private Categoria categoria;

    public ArticuloTestDataBuilder conArticuloPorDefecto() {
        this.codigo = "BOL001";
        this.nombre = "Bolígrafo Gel Escarchado";
        this.precioCompra = BigDecimal.valueOf(1500);
        this.precioVenta = BigDecimal.valueOf(2500);
        this.categoria = new CategoriaTestDataBuilder().conCategoriaPorDefecto().reconstruir();
        return this;
    }

    public ArticuloTestDataBuilder conCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public ArticuloTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ArticuloTestDataBuilder conPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
        return this;
    }

    public ArticuloTestDataBuilder conPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
        return this;
    }

    public ArticuloTestDataBuilder conCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }

    public Articulo reconstruir() {
        return Articulo.reconstruir(codigo, nombre, precioCompra, precioVenta, categoria);
    }

}
