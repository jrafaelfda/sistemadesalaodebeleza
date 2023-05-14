import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa {
    private List<Agendavel> servicosHabilitados;

    public Funcionario() {
        this.servicosHabilitados = new ArrayList<>();
    }

    public List<Agendavel> getServicosHabilitados() {
        return servicosHabilitados;
    }

    public void adicionarServicoHabilitado(Agendavel agendavel) {
        this.servicosHabilitados.add(agendavel);
    }

    public void removerServicoHabilitado(Agendavel agendavel) {
        this.servicosHabilitados.remove(agendavel);
    }
}
