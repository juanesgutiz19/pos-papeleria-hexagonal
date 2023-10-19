package com.ceiba.papeleria.articulo.consulta;

import com.ceiba.papeleria.articulo.modelo.dto.ArticuloDTO;
import com.ceiba.papeleria.articulo.puerto.dao.DaoArticulo;
import com.ceiba.papeleria.factura.modelo.dto.ResumenFacturaDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultarProductosPorNombre {

    private final DaoArticulo daoArticulo;

    public ManejadorConsultarProductosPorNombre(DaoArticulo daoArticulo) {
        this.daoArticulo = daoArticulo;
    }

    public List<ArticuloDTO> ejecutar(String nombre) {
        return daoArticulo.obtenerArticulosPorNombre(nombre);
    }

}
