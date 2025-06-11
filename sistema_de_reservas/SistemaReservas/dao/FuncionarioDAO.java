package dao;

import model.Funcionario;
import util.Serializador;

import java.util.List;

public class FuncionarioDAO {
    private final String arquivo = "dados/funcionarios.ser";

    public void salvar(List<Funcionario> funcionarios) {
        Serializador.salvarFuncionario(arquivo, funcionarios);
    }

    public List<Funcionario> carregar() {
        return Serializador.carregarFuncionario(arquivo);
    }
}
