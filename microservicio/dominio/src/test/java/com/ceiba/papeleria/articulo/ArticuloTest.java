package com.ceiba.papeleria.articulo;

import com.ceiba.papeleria.categoria.CategoriaTestDataBuilder;
import com.ceiba.papeleria.categoria.modelo.entidad.Categoria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ArticuloTest {

    @Test
    void deberiaReconstruirElArticuloCorrectamenteTest() {
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
}
