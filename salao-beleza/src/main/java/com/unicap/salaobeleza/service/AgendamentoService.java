package com.unicap.salaobeleza.service;

import com.unicap.salaobeleza.model.Agendamento;
import com.unicap.salaobeleza.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public Agendamento createAgendamento(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> getAllAgendamentos() {
        return agendamentoRepository.findAll();
    }

    public ResponseEntity<Agendamento> getAgendamentoById(Long id) {
        Optional<Agendamento> agendamento = agendamentoRepository.findById(id);
        if(agendamento.isPresent()) {
            return ResponseEntity.ok().body(agendamento.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Agendamento> updateAgendamento(Long id, Agendamento agendamentoDetails) {
        Optional<Agendamento> agendamento = agendamentoRepository.findById(id);
        if(agendamento.isPresent()) {
            Agendamento agendamentoToUpdate = agendamento.get();
            agendamentoToUpdate.setCliente(agendamentoDetails.getCliente());
            agendamentoToUpdate.setFuncionario(agendamentoDetails.getFuncionario());
            agendamentoToUpdate.setServico(agendamentoDetails.getServico());
            agendamentoToUpdate.setPacoteServicos(agendamentoDetails.getPacoteServicos());
            agendamentoToUpdate.setDataHora(agendamentoDetails.getDataHora());
            agendamentoRepository.save(agendamentoToUpdate);
            return ResponseEntity.ok().body(agendamentoToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteAgendamento(Long id) {
        Optional<Agendamento> agendamento = agendamentoRepository.findById(id);
        if(agendamento.isPresent()) {
            agendamentoRepository.delete(agendamento.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
