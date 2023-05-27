package com.unicap.salaobeleza.controller;

import com.unicap.salaobeleza.model.PacoteServicos;
import com.unicap.salaobeleza.service.PacoteServicosService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/pacoteservicos")
public class PacoteServicosController {

    private final PacoteServicosService pacoteServicosService;

    public PacoteServicosController(PacoteServicosService pacoteServicosService) {
        this.pacoteServicosService = pacoteServicosService;
    }

    @GetMapping
    public List<PacoteServicos> getAllPacoteServicos() {
        return pacoteServicosService.getAllPacoteServicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacoteServicos> getPacoteServicosById(@PathVariable Long id) {
        return ResponseEntity.ok(pacoteServicosService.getPacoteServicosById(id));
    }

    @PostMapping
    public PacoteServicos createPacoteServicos(@Validated @RequestBody PacoteServicos pacoteServicos) {
        return pacoteServicosService.createPacoteServicos(pacoteServicos);
    }

    @PutMapping("/{id}")
    public PacoteServicos updatePacoteServicos(@PathVariable Long id, @Validated @RequestBody PacoteServicos pacoteServicosDetails) {
        return pacoteServicosService.updatePacoteServicos(id, pacoteServicosDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePacoteServicos(@PathVariable Long id) {
        pacoteServicosService.deletePacoteServicos(id);
        return ResponseEntity.noContent().build();
    }
}
