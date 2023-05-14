import java.util.ArrayList;
import java.util.List;

public class PacoteServicos implements Agendavel {
    private String descricao;
    private double preco;
    private List<Servico> servicos;

    public PacoteServicos() {
        this.servicos = new ArrayList<>();
    }

    // Getters and setters
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void adicionarServico(Servico servico) {
        this.servicos.add(servico);
    }

    public void removerServico(Servico servico) {
        this.servicos.remove(servico);
    }
}
