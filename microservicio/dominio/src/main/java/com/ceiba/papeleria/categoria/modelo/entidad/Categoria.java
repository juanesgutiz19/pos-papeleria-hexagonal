package com.ceiba.papeleria.categoria.modelo.entidad;

import com.ceiba.papeleria.dominio.ValidadorArgumento;

public final class Categoria {
    private static final String MENSAJE_ID_CATEGORIA_REQUERIDO = "El id de la categoría es requerido";
    private static final String MENSAJE_DESCRIPCION_CATEGORIA_REQUERIDA = "La descripción de la categoría es requerida";

    private Long id;
    private String descripcion;

    private Categoria(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static Categoria reconstruir(Long id, String descripcion) {
        ValidadorArgumento.validarObligatorio(id, MENSAJE_ID_CATEGORIA_REQUERIDO);
        ValidadorArgumento.validarObligatorio(descripcion, MENSAJE_DESCRIPCION_CATEGORIA_REQUERIDA);
        return new Categoria(id, descripcion);
    }
}