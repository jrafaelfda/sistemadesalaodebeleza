package com.unicap.salaobeleza.service;

import com.unicap.salaobeleza.model.Cliente;
import com.unicap.salaobeleza.model.Funcionario;
import com.unicap.salaobeleza.model.PacoteServicos;
import com.unicap.salaobeleza.model.Servico;
import com.unicap.salaobeleza.model.Agendamento;
import com.unicap.salaobeleza.repository.AgendamentoRepository;
import com.unicap.salaobeleza.repository.ServicoRepository;
import com.unicap.salaobeleza.repository.PacoteServicosRepository;
import com.unicap.salaobeleza.repository.ClienteRepository;
import com.unicap.salaobeleza.repository.FuncionarioRepository;
import com.unicap.salaobeleza.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final ServicoRepository servicoRepository;
    private final PacoteServicosRepository pacoteServicosRepository;
    private final ClienteRepository clienteRepository;
    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public AgendamentoService(AgendamentoRepository agendamentoRepository,
                              ServicoRepository servicoRepository,
                              PacoteServicosRepository pacoteServicosRepository,
                              ClienteRepository clienteRepository,
                              FuncionarioRepository funcionarioRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.servicoRepository = servicoRepository;
        this.pacoteServicosRepository = pacoteServicosRepository;
        this.clienteRepository = clienteRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    public Agendamento createAgendamento(Agendamento agendamento) {
        // Verificar se Cliente e Funcionário estão presentes
        if (agendamento.getCliente() == null || agendamento.getFuncionario() == null) {
            throw new IllegalArgumentException("Cliente e Funcionário devem ser fornecidos.");
        }

        // Verificar se Serviço ou Pacote de Serviços está presente (não ambos)
        boolean hasServico = agendamento.getServico() != null;
        boolean hasPacoteServicos = agendamento.getPacoteServicos() != null;
        if ((hasServico && hasPacoteServicos) || (!hasServico && !hasPacoteServicos)) {
            throw new IllegalArgumentException("Deve ser fornecido apenas um dos seguintes: Serviço ou Pacote de Serviços.");
        }

        // Carregar o Cliente
        Cliente cliente = clienteRepository.findById(agendamento.getCliente().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        agendamento.setCliente(cliente);

        // Carregar o Funcionário
        Funcionario funcionario = funcionarioRepository.findById(agendamento.getFuncionario().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado"));
        agendamento.setFuncionario(funcionario);

        // Carregar o Serviço ou o Pacote de Serviços, conforme fornecido
        if (hasServico) {
            Servico servico = servicoRepository.findById(agendamento.getServico().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Serviço não encontrado"));
            agendamento.setServico(servico);
            agendamento.setPacoteServicos(null); // Define como nulo para garantir que não haja Pacote de Serviços
        } else {
            PacoteServicos pacoteServicos = pacoteServicosRepository.findById(agendamento.getPacoteServicos().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Pacote de Serviços não encontrado"));
            agendamento.setPacoteServicos(pacoteServicos);
            agendamento.setServico(null); // Define como nulo para garantir que não haja Serviço
        }

        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> getAllAgendamentos() {
        return agendamentoRepository.findAll();
    }

    public ResponseEntity<Agendamento> getAgendamentoById(Long id) {
        Optional<Agendamento> agendamento = agendamentoRepository.findById(id);
        if (agendamento.isPresent()) {
            return ResponseEntity.ok().body(agendamento.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Agendamento> updateAgendamento(Long id, Agendamento agendamentoDetails) {
        Optional<Agendamento> agendamento = agendamentoRepository.findById(id);
        if (agendamento.isPresent()) {
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
        if (agendamento.isPresent()) {
            agendamentoRepository.delete(agendamento.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

