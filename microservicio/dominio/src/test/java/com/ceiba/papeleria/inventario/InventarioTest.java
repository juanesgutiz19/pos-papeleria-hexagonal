package com.ceiba.papeleria.inventario;

import com.ceiba.papeleria.articulo.ArticuloTestDataBuilder;
import com.ceiba.papeleria.core.BasePrueba;
import com.ceiba.papeleria.dominio.excepcion.ExcepcionValorInvalido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InventarioTest {

    @Test
    void cuandoTodosLosDatosSonCorrectosConArticuloEntoncesDeberiaReconstruirElInventarioCorrectamenteTest() {

        var inventario = new InventarioTestDataBuilder().conInventarioPorDefecto().reconstruirConArticulo();

        Assertions.assertEquals(1L, inventario.getId());
        Assertions.assertEquals("BOL001", inventario.getArticulo().getCodigo());
        Assertions.assertEquals("Bolígrafo Gel Escarchado", inventario.getArticulo().getNombre());
        Assertions.assertEquals(BigDecimal.valueOf(1500), inventario.getArticulo().getPrecioCompra());
        Assertions.assertEquals(BigDecimal.valueOf(2500), inventario.getArticulo().getPrecioVenta());
        Assertions.assertEquals(1L, inventario.getArticulo().getCategoria().getId());
        Assertions.assertEquals("Lapiceros", inventario.getArticulo().getCategoria().getDescripcion());
        Assertions.assertEquals(3, inventario.getCantidadDisponible());
        Assertions.assertEquals(LocalDate.of(2023, 2, 2), inventario.getFechaEntrada());

    }

    @Test
    void cuandoTodosLosDatosSonCorrectosSinArticuloEntoncesDeberiaReconstruirElInventarioCorrectamenteTest() {

        var inventario = new InventarioTestDataBuilder().conInventarioPorDefecto().reconstruirSinArticulo();

        Assertions.assertEquals(1L, inventario.getId());
        Assertions.assertEquals(3, inventario.getCantidadDisponible());
        Assertions.assertEquals(LocalDate.of(2023, 2, 2), inventario.getFechaEntrada());

    }

    @Test
    void cuandoLaCantidadDisponibleEsMenorACeroAEntoncesDeberiaLanzarExcepcionValorInvalidoTest() {

        BasePrueba.assertThrows(() -> new InventarioTestDataBuilder()
                .conId(1L)
                .conCantidadDisponible(-5)
                .conFechaEntrada(LocalDate.now())
                .conArticulo(
                        new ArticuloTestDataBuilder().
                                conArticuloPorDefecto()
                                .reconstruir())
                .reconstruirConArticulo(), ExcepcionValorInvalido.class, "La cantidad disponible no puede ser menor a cero");

    }

    @Test
    public void cuandoLaCantidadAAgregarEsValidaEntoncesSeDeberiaIncrementarLaCantidadDisponible() {

        var inventario = new InventarioTestDataBuilder().conInventarioPorDefecto().reconstruirConArticulo();

        int cantidadAAgregar = 3;

        inventario.actualizarCantidadDisponible(cantidadAAgregar);

        Assertions.assertEquals(6, inventario.getCantidadDisponible());
    }

    @Test
    public void cuandoLaCantidadAAgregarNoEsPositivaEntoncesSeDeberiaLanzarExcepcionValorInvalidoTest() {

        var inventario = new InventarioTestDataBuilder().conInventarioPorDefecto().reconstruirConArticulo();

        int cantidadAAgregar = -2;

        BasePrueba.assertThrows(() -> inventario.actualizarCantidadDisponible(cantidadAAgregar), ExcepcionValorInvalido.class, "La cantidad a agregar del artículo debe ser positiva");

    }

}


