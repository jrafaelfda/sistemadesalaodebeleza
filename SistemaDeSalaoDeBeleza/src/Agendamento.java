import java.time.LocalDateTime;

public class Agendamento {
    private Cliente cliente;
    private Agendavel agendavel;
    private Funcionario funcionario;
    private LocalDateTime dataHora;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Agendavel getAgendavel() {
        return agendavel;
    }

    public void setAgendavel(Agendavel agendavel) {
        this.agendavel = agendavel;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
