package com.unicap.salaobeleza.service;

import com.unicap.salaobeleza.model.Funcionario;
import com.unicap.salaobeleza.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> getFuncionarioById(Long id) {
        return funcionarioRepository.findById(id);
    }

    public Funcionario createFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Optional<Funcionario> updateFuncionario(Long id, Funcionario funcionarioDetails) {
        return funcionarioRepository.findById(id)
            .map(funcionario -> {
                funcionario.setNome(funcionarioDetails.getNome());
                funcionario.setServicosHabilitados(funcionarioDetails.getServicosHabilitados());
                return funcionarioRepository.save(funcionario);
            });
    }

    public boolean deleteFuncionario(Long id) {
        if(funcionarioRepository.existsById(id)) {
            funcionarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
