package com.ceiba.papeleria.articulo;

import com.ceiba.papeleria.categoria.CategoriaTestDataBuilder;
import com.ceiba.papeleria.categoria.modelo.entidad.Categoria;
import com.ceiba.papeleria.core.BasePrueba;
import com.ceiba.papeleria.dominio.excepcion.ExcepcionValorInvalido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ArticuloTest {

    @Test
    void cuandoTodosLosDatosSonCorrectosEntoncesDeberiaReconstruirElArticuloCorrectamenteTest() {

        Categoria categoria = new CategoriaTestDataBuilder()
                .conCategoriaPorDefecto()
                .reconstruir();

        var articulo = new ArticuloTestDataBuilder()
                .conArticuloPorDefecto()
                .reconstruir();

        Assertions.assertEquals("BOL001", articulo.getCodigo());
        Assertions.assertEquals("Bolígrafo Gel Escarchado", articulo.getNombre());
        Assertions.assertEquals(BigDecimal.valueOf(1500), articulo.getPrecioCompra());
        Assertions.assertEquals(BigDecimal.valueOf(2500), articulo.getPrecioVenta());
        Assertions.assertEquals(categoria.getId(), articulo.getCategoria().getId());
        Assertions.assertEquals(categoria.getDescripcion(), articulo.getCategoria().getDescripcion());

    }

    @Test
    void cuandoElPrecioCompraEsMenorOIgualACeroAEntoncesDeberiaLanzarExcepcionValorInvalidoTest() {

        Categoria categoria = new CategoriaTestDataBuilder()
                .conCategoriaPorDefecto()
                .reconstruir();

        BasePrueba.assertThrows(() -> new ArticuloTestDataBuilder()
                .conCodigo("BOL002")
                .conNombre("Bolígrafo borrable Rocketbook")
                .conPrecioCompra(BigDecimal.valueOf(-1))
                .conPrecioVenta(BigDecimal.valueOf(8000))
                .conCategoria(categoria)
                .reconstruir(), ExcepcionValorInvalido.class, "Ni el precio de compra ni el precio de venta pueden ser menores o iguales a cero");

    }

    @Test
    void cuandoElPrecioVentaEsMenorOIgualACeroAEntoncesDeberiaLanzarExcepcionValorInvalidoTest() {

        Categoria categoria = new CategoriaTestDataBuilder()
                .conCategoriaPorDefecto()
                .reconstruir();

        BasePrueba.assertThrows(() -> new ArticuloTestDataBuilder()
                .conCodigo("BOL002")
                .conNombre("Bolígrafo borrable Rocketbook")
                .conPrecioCompra(BigDecimal.valueOf(6000))
                .conPrecioVenta(BigDecimal.valueOf(-1))
                .conCategoria(categoria)
                .reconstruir(), ExcepcionValorInvalido.class, "Ni el precio de compra ni el precio de venta pueden ser menores o iguales a cero");

    }

    @Test
    void cuandoElPrecioCompraNoEsMayorQueElPrecioVentaEntoncesDeberiaLanzarExcepcionValorInvalidoTest() {

        Categoria categoria = new CategoriaTestDataBuilder()
                .conCategoriaPorDefecto()
                .reconstruir();

        BasePrueba.assertThrows(() -> new ArticuloTestDataBuilder()
                .conCodigo("BOL002")
                .conNombre("Bolígrafo borrable Rocketbook")
                .conPrecioCompra(BigDecimal.valueOf(6000))
                .conPrecioVenta(BigDecimal.valueOf(5000))
                .conCategoria(categoria)
                .reconstruir(), ExcepcionValorInvalido.class, "El precio de venta debe ser mayor al precio de compra");
    }

}
