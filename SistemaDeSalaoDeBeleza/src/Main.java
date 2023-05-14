import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();
        List<Funcionario> funcionarios = new ArrayList<>();
        List<Agendavel> agendaveis = new ArrayList<>();
        List<Agendamento> agendamentos = new ArrayList<>();

        // instancia pra testagem

        Cliente cliente = new Cliente();
        cliente.setNome("Marcus");
        clientes.add(cliente);

        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Eduarda");
        funcionarios.add(funcionario);

        Servico servico = new Servico();
        servico.setDescricao("Corte de cabelo");
        servico.setPreco(50.0);
        funcionario.adicionarServicoHabilitado(servico);
        agendaveis.add(servico);


        Agendamento agendamento = new Agendamento();
        agendamento.setCliente(cliente);
        agendamento.setFuncionario(funcionario);
        agendamento.setAgendavel(servico);
        agendamento.setDataHora(LocalDateTime.now());
        agendamentos.add(agendamento);

        System.out.println("Salão: Alta Estima");
        System.out.println("Número de clientes: " + clientes.size());
        System.out.println("Número de funcionários: " + funcionarios.size());
        System.out.println("Número de serviços disponíveis: " + agendaveis.size());
        System.out.println("Número de agendamentos: " + agendamentos.size());
    }
}
