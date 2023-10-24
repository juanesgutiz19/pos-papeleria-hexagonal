package com.ceiba.papeleria.factura.controlador;

import com.ceiba.papeleria.ApplicationMock;
import com.ceiba.papeleria.articulo.controlador.ConsultaControladorArticulo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.hasSize;


@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorArticulo.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ConsultaControladorArticuloTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String RUTA_ARTICULOS = "/articulos";

    @Test
    void obtenerArticulosPorNombreConArticulosExistentesDebeRetornarStatusOkYDevolverArticulosCorrectamenteTest() throws Exception {

        String valorCorrectoParametroPeticionNombre = "Cuaderno";
        mockMvc.perform(get(RUTA_ARTICULOS)
                        .param("nombre", valorCorrectoParametroPeticionNombre))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].codigo", is("CUA001")))
                .andExpect(jsonPath("$[0].nombre", is("Cuaderno Espiral Rayado")))
                .andExpect(jsonPath("$[0].precioCompra", is(2000.0)))
                .andExpect(jsonPath("$[0].precioVenta", is(2500.0)))
                .andExpect(jsonPath("$[1].codigo", is("CUA002")))
                .andExpect(jsonPath("$[1].nombre", is("Cuaderno Cuadriculado Grande")))
                .andExpect(jsonPath("$[1].precioCompra", is(3100.0)))
                .andExpect(jsonPath("$[1].precioVenta", is(4000.0)));
    }

    @Test
    void obtenerArticulosPorNombreConArticulosNoExistentesDebeRetornarStatusOkYDevolverUnaListaDeArticulosVaciaTest() throws Exception {

        String valorIncorrectoParametroPeticionNombre = "Calculadora";
        mockMvc.perform(get(RUTA_ARTICULOS)
                        .param("nombre", valorIncorrectoParametroPeticionNombre))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

}
