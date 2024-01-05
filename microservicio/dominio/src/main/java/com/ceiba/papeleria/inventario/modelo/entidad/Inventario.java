package com.ceiba.papeleria.inventario.modelo.entidad;

import com.ceiba.papeleria.articulo.modelo.entidad.Articulo;
import com.ceiba.papeleria.dominio.ValidadorArgumento;
import com.ceiba.papeleria.dominio.excepcion.ExcepcionValorInvalido;

import java.time.LocalDate;

public final class Inventario {

    private static final String ID_INVENTARIO_OBLIGATORIO = "El id del registro del inventario es obligatorio";
    private static final String ARTICULO_INVENTARIO_OBLIGATORIO = "El artículo del registro del inventario es obligatorio";
    private static final String CANTIDAD_DISPONIBLE_OBLIGATORIA = "La cantidad disponible del registro del inventario es obligatoria";
    private static final String FECHA_ENTRADA_OBLIGATORIA = "La fecha de entrada del registro del inventario es obligatoria";
    private static final String CANTIDAD_POSITIVA = "La cantidad a agregar del artículo debe ser positiva";
    private static final String CANTIDAD_DISPONIBLE_NO_NEGATIVA = "La cantidad disponible no puede ser menor a cero";

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
        ValidadorArgumento.validarPositivo(Double.valueOf(cantidadAAgregar), CANTIDAD_POSITIVA);
        this.cantidadDisponible = this.getCantidadDisponible() + cantidadAAgregar;
    }

    private static void validarCantidadDisponible(Integer cantidadDisponible) {
        if (cantidadDisponible < 0) {
            throw new ExcepcionValorInvalido(CANTIDAD_DISPONIBLE_NO_NEGATIVA);
        }
    }

    public static Inventario reconstruir(Long id, Articulo articulo, Integer cantidadDisponible, LocalDate fechaEntrada) {
        ValidadorArgumento.validarObligatorio(id, ID_INVENTARIO_OBLIGATORIO);
        ValidadorArgumento.validarObligatorio(articulo, ARTICULO_INVENTARIO_OBLIGATORIO);
        ValidadorArgumento.validarObligatorio(cantidadDisponible, CANTIDAD_DISPONIBLE_OBLIGATORIA);
        ValidadorArgumento.validarObligatorio(fechaEntrada, FECHA_ENTRADA_OBLIGATORIA);
        validarCantidadDisponible(cantidadDisponible);
        return new Inventario(id, articulo, cantidadDisponible, fechaEntrada);
    }

    public static Inventario reconstruir(Long id, Integer cantidadDisponible, LocalDate fechaEntrada) {
        ValidadorArgumento.validarObligatorio(id, ID_INVENTARIO_OBLIGATORIO);
        ValidadorArgumento.validarObligatorio(cantidadDisponible, CANTIDAD_DISPONIBLE_OBLIGATORIA);
        ValidadorArgumento.validarObligatorio(fechaEntrada, FECHA_ENTRADA_OBLIGATORIA);
        validarCantidadDisponible(cantidadDisponible);
        return new Inventario(id, null, cantidadDisponible, fechaEntrada);
    }
}