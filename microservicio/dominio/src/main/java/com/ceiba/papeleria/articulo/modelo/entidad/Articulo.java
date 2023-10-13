package com.ceiba.papeleria.articulo.modelo.entidad;

import com.ceiba.papeleria.categoria.modelo.entidad.Categoria;
import com.ceiba.papeleria.dominio.ValidadorArgumento;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Articulo {

    private String codigo;
    private String nombre;
    private BigDecimal precioCompra;
    private BigDecimal precioVenta;
    private Categoria categoria;

    private static Articulo reconstruir(String codigo, String nombre, BigDecimal precioCompra, BigDecimal precioVenta, Categoria categoria) {
        ValidadorArgumento.validarObligatorio(codigo, "El código del artículo es obligatorio");
        ValidadorArgumento.validarObligatorio(nombre, "El nombre del artículo es obligatorio");
        ValidadorArgumento.validarObligatorio(precioCompra, "El precio de compra del artículo es obligatorio");
        ValidadorArgumento.validarObligatorio(precioVenta, "El precio de venta del artículo es obligatorio");
        ValidadorArgumento.validarObligatorio(categoria, "La categoria del artículo es obligatoria");
        return new Articulo(codigo, nombre, precioCompra, precioVenta, categoria);
    }
}
