package com.unicap.salaobeleza.service;

import com.unicap.salaobeleza.model.PacoteServicos;
import com.unicap.salaobeleza.repository.PacoteServicosRepository;
import com.unicap.salaobeleza.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class PacoteServicosService {

    private final PacoteServicosRepository pacoteServicosRepository;

    public PacoteServicosService(PacoteServicosRepository pacoteServicosRepository) {
        this.pacoteServicosRepository = pacoteServicosRepository;
    }

    public List<PacoteServicos> getAllPacoteServicos() {
        return pacoteServicosRepository.findAll();
    }

    public PacoteServicos getPacoteServicosById(Long id) {
        return pacoteServicosRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("PacoteServicos", "id", id));
    }

    public PacoteServicos createPacoteServicos(PacoteServicos pacoteServicos) {
        return pacoteServicosRepository.save(pacoteServicos);
    }

    public PacoteServicos updatePacoteServicos(Long id, PacoteServicos pacoteServicosDetails) {
        PacoteServicos pacoteServicos = getPacoteServicosById(id);

        pacoteServicos.setNome(pacoteServicosDetails.getNome());
        pacoteServicos.setServicos(pacoteServicosDetails.getServicos());

        return pacoteServicosRepository.save(pacoteServicos);
    }

    public void deletePacoteServicos(Long id) {
        PacoteServicos pacoteServicos = getPacoteServicosById(id);
        pacoteServicosRepository.delete(pacoteServicos);
    }
}
