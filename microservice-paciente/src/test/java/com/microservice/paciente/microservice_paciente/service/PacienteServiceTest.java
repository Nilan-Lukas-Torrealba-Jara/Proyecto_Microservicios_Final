
package com.microservice.paciente.microservice_paciente.service;

import com.microservice.paciente.microservice_paciente.model.Paciente;
import com.microservice.paciente.microservice_paciente.repository.PacienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PacienteServiceTest {

    @Mock
    private PacienteRepository pacienteRepository;

    @InjectMocks
    private PacienteService pacienteService;

    private Paciente paciente;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        paciente = new Paciente(1L, "Juan", "Pérez", "12345678-9");
    }

    @Test
    public void testGuardarPaciente() {
        when(pacienteRepository.save(paciente)).thenReturn(paciente);
        Paciente result = pacienteService.guardarPaciente(paciente);
        assertEquals("Juan", result.getNombre());
    }

    @Test
    public void testBuscarPorId() {
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(paciente));
        Optional<Paciente> result = pacienteService.buscarPorId(1L);
        assertTrue(result.isPresent());
        assertEquals("Pérez", result.get().getApellido());
    }
}
