package com.ceiba.papeleria.categoria.modelo.entidad;

import com.ceiba.papeleria.dominio.ValidadorArgumento;
import lombok.Getter;


@Getter
public class Categoria {
    private Long id;
    private String descripcion;

    private Categoria(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public static Categoria reconstruir(Long id, String descripcion) {
        ValidadorArgumento.validarObligatorio(id, "El id de la categoría es requerido");
        ValidadorArgumento.validarObligatorio(descripcion, "La descripción de la categoría es requerida");
        return new Categoria(id, descripcion);
    }

}