package com.ceiba.papeleria.articulo.consulta;

import com.ceiba.papeleria.articulo.modelo.dto.ArticuloDTO;
import com.ceiba.papeleria.articulo.puerto.dao.DaoArticulo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultarArticulosPorNombre {

    private final DaoArticulo daoArticulo;

    public ManejadorConsultarArticulosPorNombre(DaoArticulo daoArticulo) {
        this.daoArticulo = daoArticulo;
    }

    public List<ArticuloDTO> ejecutar(String nombre) {
        return daoArticulo.obtenerArticulosPorNombre(nombre);
    }

}
