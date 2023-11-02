package com.ceiba.papeleria.categoria;

import com.ceiba.papeleria.categoria.modelo.entidad.Categoria;

public class CategoriaTestDataBuilder {

    private Long id;
    private String descripcion;

    public CategoriaTestDataBuilder conCategoriaPorDefecto() {
        this.id = 1L;
        this.descripcion = "Lapiceros";
        return this;
    }

    public CategoriaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public CategoriaTestDataBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Categoria reconstruir() {
        return Categoria.reconstruir(id, descripcion);
    }

}
