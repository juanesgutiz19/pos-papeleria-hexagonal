package com.ceiba.papeleria.inventario.controlador;

import com.ceiba.papeleria.ApplicationMock;
import com.ceiba.papeleria.inventario.controlador.testdatabuilder.ComandoActualizarCantidadDisponibleTestDataBuilder;
import com.ceiba.papeleria.inventario.puerto.repositorio.RepositorioInventario;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorInventario.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorInventarioTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    private static final String RUTA_INVENTARIO = "/inventario";

    @Autowired
    private RepositorioInventario repositorioInventario;

    @Test
    void actualizarLaCantidadDisponibleDeUnArticuloDelInventarioDebeRetornarStatusNotModified204YSumarLaCantidadDisponibleCorrectamenteTest() throws Exception {

        var comandoActualizarCantidadDisponibleDataBuilder = new ComandoActualizarCantidadDisponibleTestDataBuilder().crearPorDefecto().build();

        mockMvc.perform(patch(RUTA_INVENTARIO)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoActualizarCantidadDisponibleDataBuilder))).
                andExpect(status().isNoContent());

        var registroDeInventarioConNuevaCantidadDisponible = repositorioInventario.obtenerPorArticulo("CUA001");

        Assertions.assertEquals(4, registroDeInventarioConNuevaCantidadDisponible.getCantidadDisponible());
    }

    @Test
    void actualizarLaCantidadDisponibleDeUnArticuloDelInventarioConUnIdArticuloNoExistenteDebeRetornarStatusBadRequest400() throws Exception {

        var comandoActualizarCantidadDisponibleDataBuilder = new ComandoActualizarCantidadDisponibleTestDataBuilder().conIdArticulo("CUA009").conCantidad(3).build();

        mockMvc.perform(patch(RUTA_INVENTARIO)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoActualizarCantidadDisponibleDataBuilder))).
                andExpect(status().isBadRequest());
    }

    @Test
    void actualizarLaCantidadDisponibleDeUnArticuloDelInventarioConUnaCantidadNoPositivaDebeRetornarStatusBadRequest400() throws Exception {

        var comandoActualizarCantidadDisponibleDataBuilder = new ComandoActualizarCantidadDisponibleTestDataBuilder().conIdArticulo("CUA001").conCantidad(-1).build();

        mockMvc.perform(patch(RUTA_INVENTARIO)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoActualizarCantidadDisponibleDataBuilder))).
                andExpect(status().isBadRequest());
    }
}
