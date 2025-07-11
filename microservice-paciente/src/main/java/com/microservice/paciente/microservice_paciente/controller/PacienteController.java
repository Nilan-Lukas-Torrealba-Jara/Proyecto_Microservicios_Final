
package com.microservice.paciente.microservice_paciente.controller;

import com.microservice.paciente.microservice_paciente.model.Paciente;
import com.microservice.paciente.microservice_paciente.service.PacienteService;
import com.microservice.paciente.microservice_paciente.util.DataFakerUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Operation(summary = "Obtener todos los pacientes")
    @GetMapping
    public List<EntityModel<Paciente>> listarTodos() {
        return pacienteService.listarTodos().stream()
            .map(p -> EntityModel.of(p,
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PacienteController.class).buscarPorId(p.getId())).withSelfRel()
            )).collect(Collectors.toList());
    }

    @Operation(summary = "Buscar paciente por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Paciente encontrado"),
        @ApiResponse(responseCode = "404", description = "Paciente no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Paciente>> buscarPorId(@PathVariable Long id) {
        Optional<Paciente> pacienteOpt = pacienteService.buscarPorId(id);
        return pacienteOpt.map(paciente -> {
            EntityModel<Paciente> model = EntityModel.of(paciente);
            Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PacienteController.class).buscarPorId(id)).withSelfRel();
            model.add(selfLink);
            return ResponseEntity.ok(model);
        }).orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Guardar paciente")
    @PostMapping
    public ResponseEntity<Paciente> guardar(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.guardarPaciente(paciente));
    }

    @Operation(summary = "Eliminar paciente por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Generar paciente de prueba con Faker")
    @GetMapping("/faker")
    public ResponseEntity<Paciente> generarPacienteFalso() {
        return ResponseEntity.ok(DataFakerUtil.generarPacienteFalso());
    }
}
