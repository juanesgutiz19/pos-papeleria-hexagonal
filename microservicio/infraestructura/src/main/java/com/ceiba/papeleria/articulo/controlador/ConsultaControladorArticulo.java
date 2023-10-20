package com.ceiba.papeleria.articulo.controlador;

import com.ceiba.papeleria.articulo.consulta.ManejadorConsultarArticulosPorNombre;
import com.ceiba.papeleria.articulo.modelo.dto.ArticuloDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articulos")
@Tag(name = "Controlador consulta articulos")
public class ConsultaControladorArticulo {
    private final ManejadorConsultarArticulosPorNombre manejadorConsultarArticulosPorNombre;

    public ConsultaControladorArticulo(ManejadorConsultarArticulosPorNombre manejadorConsultarArticulosPorNombre) {
        this.manejadorConsultarArticulosPorNombre = manejadorConsultarArticulosPorNombre;
    }

    @GetMapping
    @Operation(summary = "Obtener articulos por nombre", description = "Metodo utilizado para consultar los articulos dado un nombre")
    public List<ArticuloDTO> obtenerArticulosPorNombre(@RequestParam("nombre") String nombre) {
        return manejadorConsultarArticulosPorNombre.ejecutar(nombre);
    }
}
