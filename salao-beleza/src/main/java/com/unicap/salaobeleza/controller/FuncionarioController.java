package com.unicap.salaobeleza.controller;

import com.unicap.salaobeleza.model.Funcionario;
import com.unicap.salaobeleza.service.FuncionarioService;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
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
        return funcionarioService.getFuncionarioById(funcionarioId)
            .map(funcionario -> ResponseEntity.ok().body(funcionario))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.createFuncionario(funcionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable(value = "id") Long funcionarioId,
                                                         @RequestBody Funcionario funcionarioDetails) {
        return funcionarioService.updateFuncionario(funcionarioId, funcionarioDetails)
            .map(updatedFuncionario -> ResponseEntity.ok().body(updatedFuncionario))
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable(value = "id") Long funcionarioId) {
        if (funcionarioService.deleteFuncionario(funcionarioId)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
