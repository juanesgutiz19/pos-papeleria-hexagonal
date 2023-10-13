package com.ceiba.papeleria.inventario.modelo.entidad;

import com.ceiba.papeleria.articulo.modelo.entidad.Articulo;
import com.ceiba.papeleria.dominio.ValidadorArgumento;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Inventario {

    private Long id;
    private Articulo articulo;
    private Integer cantidadDisponible;
    private LocalDate fechaEntrada;

    private static Inventario reconstruir(Long id, Articulo articulo, Integer cantidadDisponible, LocalDate fechaEntrada) {
        ValidadorArgumento.validarObligatorio(id, "El id del registro del inventario es obligatorio");
        ValidadorArgumento.validarObligatorio(articulo, "El artículo del registro del inventario es obligatorio");
        ValidadorArgumento.validarObligatorio(cantidadDisponible, "La cantidad disponible del registro del inventario es obligatorio");
        ValidadorArgumento.validarObligatorio(fechaEntrada, "La fecha de entrada del registro del inventario es obligatorio");
        return new Inventario(id, articulo, cantidadDisponible, fechaEntrada);
    }

}
