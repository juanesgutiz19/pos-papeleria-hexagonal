package com.ceiba.papeleria.inventario.controlador;


import com.ceiba.papeleria.inventario.comando.ComandoActualizarCantidadDisponible;
import com.ceiba.papeleria.inventario.comando.manejador.ManejadorActualizarCantidadDisponibleArticulo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventario")
@Tag(name = "Controlador comando inventario")
public class ComandoControladorInventario {

    private final ManejadorActualizarCantidadDisponibleArticulo manejadorActualizarCantidadDisponibleArticulo;

    public ComandoControladorInventario(ManejadorActualizarCantidadDisponibleArticulo manejadorActualizarCantidadDisponibleArticulo) {
        this.manejadorActualizarCantidadDisponibleArticulo = manejadorActualizarCantidadDisponibleArticulo;
    }

    @PatchMapping
    @Operation(summary = "Actualizar cantidad disponible", description = "Método utilizado para actualizar la cantidad disponible de un artículo del inventario")
    public ResponseEntity<Void> actualizarCantidadDisponibleArticulo(@RequestBody ComandoActualizarCantidadDisponible comandoActualizarCantidadDisponible) {
        this.manejadorActualizarCantidadDisponibleArticulo.ejecutar(comandoActualizarCantidadDisponible);
        return ResponseEntity.noContent().build();
    }

}
