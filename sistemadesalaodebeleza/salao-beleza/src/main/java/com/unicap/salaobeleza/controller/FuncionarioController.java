package com.unicap.salaobeleza.controller;

import com.unicap.salaobeleza.model.Funcionario;
import com.unicap.salaobeleza.service.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioService.getAllFuncionarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable(value = "id") Long funcionarioId) {
        Funcionario funcionario = funcionarioService.getFuncionarioById(funcionarioId);
        return ResponseEntity.ok().body(funcionario);
    }

    @PostMapping
    public Funcionario createFuncionario(@Valid @RequestBody Funcionario funcionario) {
        return funcionarioService.createFuncionario(funcionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable(value = "id") Long funcionarioId,
                                                     @Valid @RequestBody Funcionario funcionarioDetails) {
        Funcionario updatedFuncionario = funcionarioService.updateFuncionario(funcionarioId, funcionarioDetails);
        return ResponseEntity.ok(updatedFuncionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable(value = "id") Long funcionarioId) {
        boolean isDeleted = funcionarioService.deleteFuncionario(funcionarioId);
        if(isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
