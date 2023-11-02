package com.ceiba.papeleria.inventario;

import com.ceiba.papeleria.articulo.ArticuloTestDataBuilder;
import com.ceiba.papeleria.articulo.modelo.entidad.Articulo;
import com.ceiba.papeleria.inventario.modelo.entidad.Inventario;

import java.time.LocalDate;

public class InventarioTestDataBuilder {

    private Long id;
    private Articulo articulo;
    private Integer cantidadDisponible;
    private LocalDate fechaEntrada;

    public InventarioTestDataBuilder conInventarioPorDefecto() {
        this.id = 1L;
        this.articulo = new ArticuloTestDataBuilder().conArticuloPorDefecto().reconstruir();
        this.cantidadDisponible = 3;
        this.fechaEntrada = LocalDate.of(2023, 2, 2);
        return this;
    }

    public InventarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public InventarioTestDataBuilder conArticulo(Articulo articulo) {
        this.articulo = articulo;
        return this;
    }

    public InventarioTestDataBuilder conCantidadDisponible(Integer cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
        return this;
    }

    public InventarioTestDataBuilder conFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
        return this;
    }

    public Inventario reconstruirConArticulo() {
        return Inventario.reconstruir(id, articulo, cantidadDisponible, fechaEntrada);
    }

    public Inventario reconstruirSinArticulo() {
        return Inventario.reconstruir(id, cantidadDisponible, fechaEntrada);
    }

}
