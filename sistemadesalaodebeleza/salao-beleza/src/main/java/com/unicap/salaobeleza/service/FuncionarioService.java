package com.unicap.salaobeleza.service;

import com.unicap.salaobeleza.exception.ResourceNotFoundException;
import com.unicap.salaobeleza.model.Funcionario;
import com.unicap.salaobeleza.model.Servico;
import com.unicap.salaobeleza.repository.FuncionarioRepository;
import com.unicap.salaobeleza.repository.ServicoRepository;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final ServicoRepository servicoRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, ServicoRepository servicoRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.servicoRepository = servicoRepository;
    }

    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario getFuncionarioById(Long id) {
        return funcionarioRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Funcionario com id " + id + " não encontrado."));
    }

    public Funcionario createFuncionario(Funcionario funcionario) {
        Set<Servico> servicosHabilitados = new HashSet<>();
        for (Servico servico : funcionario.getServicosHabilitados()) {
            Servico servicoCompleto = servicoRepository.findById(servico.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Servico com id " + servico.getId() + " não encontrado."));
            servicosHabilitados.add(servicoCompleto);
        }
        funcionario.setServicosHabilitados(servicosHabilitados);
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario updateFuncionario(Long id, Funcionario funcionarioDetails) {
        Funcionario funcionario = getFuncionarioById(id);
        funcionario.setNome(funcionarioDetails.getNome());

        Set<Servico> servicosHabilitados = new HashSet<>();
        for (Servico servico : funcionarioDetails.getServicosHabilitados()) {
            Servico servicoCompleto = servicoRepository.findById(servico.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Servico com id " + servico.getId() + " não encontrado."));
            servicosHabilitados.add(servicoCompleto);
        }
        funcionario.setServicosHabilitados(servicosHabilitados);
        
        return funcionarioRepository.save(funcionario);
    }

    public boolean deleteFuncionario(Long id) {
        if(funcionarioRepository.existsById(id)) {
            funcionarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

