package com.ceiba.papeleria.categoria.modelo.entidad;

import com.ceiba.papeleria.dominio.ValidadorArgumento;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Categoria {

    private Long id;
    private String descripcion;

    private static Categoria reconstruir(Long id, String descripcion) {
        ValidadorArgumento.validarObligatorio(id, "El id de la categoría es requerido");
        ValidadorArgumento.validarObligatorio(descripcion, "La descripción de la categoría es requerida");
        return new Categoria(id, descripcion);
    }
}