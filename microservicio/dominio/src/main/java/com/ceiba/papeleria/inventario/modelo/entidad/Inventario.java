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

}
