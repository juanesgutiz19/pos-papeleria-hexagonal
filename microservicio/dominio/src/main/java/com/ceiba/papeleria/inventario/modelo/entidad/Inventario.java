package com.ceiba.papeleria.inventario.modelo.entidad;

import com.ceiba.papeleria.articulo.modelo.entidad.Articulo;
import com.ceiba.papeleria.dominio.ValidadorArgumento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Getter
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

    public void actualizarCantidadDisponible(Integer cantidadAAgregar) {
        ValidadorArgumento.validarPositivo(Double.valueOf(cantidadAAgregar), "La cantidad a agregar del artículo debe ser positiva");
        this.cantidadDisponible = this.getCantidadDisponible() + cantidadAAgregar;
    }

    public static Inventario reconstruir(Long id, Articulo articulo, Integer cantidadDisponible, LocalDate fechaEntrada) {
        ValidadorArgumento.validarObligatorio(id, "El id del registro del inventario es obligatorio");
        ValidadorArgumento.validarObligatorio(articulo, "El artículo del registro del inventario es obligatorio");
        ValidadorArgumento.validarObligatorio(cantidadDisponible, "La cantidad disponible del registro del inventario es obligatoria");
        ValidadorArgumento.validarObligatorio(fechaEntrada, "La fecha de entrada del registro del inventario es obligatoria");
        return new Inventario(id, articulo, cantidadDisponible, fechaEntrada);
    }

    public static Inventario reconstruir(Long id, Integer cantidadDisponible, LocalDate fechaEntrada) {
        ValidadorArgumento.validarObligatorio(id, "El id del registro del inventario es obligatorio");
        ValidadorArgumento.validarObligatorio(cantidadDisponible, "La cantidad disponible del registro del inventario es obligatoria");
        ValidadorArgumento.validarObligatorio(fechaEntrada, "La fecha de entrada del registro del inventario es obligatoria");
        return new Inventario(id, null, cantidadDisponible, fechaEntrada);
    }

}
