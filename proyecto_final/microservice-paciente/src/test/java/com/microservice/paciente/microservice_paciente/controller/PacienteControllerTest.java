
package com.microservice.paciente.microservice_paciente.controller;

import com.microservice.paciente.microservice_paciente.model.Paciente;
import com.microservice.paciente.microservice_paciente.service.PacienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PacienteController.class)
public class PacienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PacienteService pacienteService;

    private Paciente paciente;

    @BeforeEach
    public void setup() {
        paciente = new Paciente(1L, "Test", "Paciente", "11.111.111-1");
    }

    @Test
    public void testBuscarPorId() throws Exception {
        when(pacienteService.buscarPorId(1L)).thenReturn(Optional.of(paciente));

        mockMvc.perform(get("/api/pacientes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Test"));
    }

    @Test
    public void testListarTodos() throws Exception {
        when(pacienteService.listarTodos()).thenReturn(Arrays.asList(paciente));

        mockMvc.perform(get("/api/pacientes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].content.nombre").value("Test"));
    }
}
