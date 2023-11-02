package com.ceiba.papeleria.inventario.modelo.entidad;

import com.ceiba.papeleria.articulo.modelo.entidad.Articulo;
import com.ceiba.papeleria.dominio.ValidadorArgumento;
import com.ceiba.papeleria.dominio.excepcion.ExcepcionValorInvalido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class Inventario {

    private Long id;
    private Articulo articulo;
    private Integer cantidadDisponible;
    private LocalDate fechaEntrada;

    private Inventario(Long id, Articulo articulo, Integer cantidadDisponible, LocalDate fechaEntrada) {
        this.id = id;
        this.articulo = articulo;
        this.cantidadDisponible = cantidadDisponible;
        this.fechaEntrada = fechaEntrada;
    }

    public Long getId() {
        return id;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void actualizarCantidadDisponible(Integer cantidadAAgregar) {
        ValidadorArgumento.validarPositivo(Double.valueOf(cantidadAAgregar), "La cantidad a agregar del artículo debe ser positiva");
        this.cantidadDisponible = this.getCantidadDisponible() + cantidadAAgregar;
    }

    private static void validarCantidadDisponible(Integer cantidadDisponible) {
        if (cantidadDisponible < 0) {
            throw new ExcepcionValorInvalido("La cantidad disponible no puede ser menor a cero");
        }
    }

    public static Inventario reconstruir(Long id, Articulo articulo, Integer cantidadDisponible, LocalDate fechaEntrada) {
        ValidadorArgumento.validarObligatorio(id, "El id del registro del inventario es obligatorio");
        ValidadorArgumento.validarObligatorio(articulo, "El artículo del registro del inventario es obligatorio");
        ValidadorArgumento.validarObligatorio(cantidadDisponible, "La cantidad disponible del registro del inventario es obligatoria");
        ValidadorArgumento.validarObligatorio(fechaEntrada, "La fecha de entrada del registro del inventario es obligatoria");
        validarCantidadDisponible(cantidadDisponible);
        return new Inventario(id, articulo, cantidadDisponible, fechaEntrada);
    }

    public static Inventario reconstruir(Long id, Integer cantidadDisponible, LocalDate fechaEntrada) {
        ValidadorArgumento.validarObligatorio(id, "El id del registro del inventario es obligatorio");
        ValidadorArgumento.validarObligatorio(cantidadDisponible, "La cantidad disponible del registro del inventario es obligatoria");
        ValidadorArgumento.validarObligatorio(fechaEntrada, "La fecha de entrada del registro del inventario es obligatoria");
        validarCantidadDisponible(cantidadDisponible);
        return new Inventario(id, null, cantidadDisponible, fechaEntrada);
    }

}
