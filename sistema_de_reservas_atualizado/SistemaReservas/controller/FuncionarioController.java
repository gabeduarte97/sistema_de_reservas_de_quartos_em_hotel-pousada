package controller;

import dao.FuncionarioDAO;
import model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {
    private List<Funcionario> funcionarios;
    private final FuncionarioDAO dao;

    public FuncionarioController() {
        dao = new FuncionarioDAO();
        funcionarios = dao.carregar();
        if (funcionarios == null || funcionarios.isEmpty()) {
            funcionarios = new ArrayList<>();
            // Cria um funcionário padrão para teste
            funcionarios.add(new Funcionario("Admin", "00000000000", "admin", "admin123"));
            dao.salvar(funcionarios);
        }
    }

    public boolean autenticar(String usuario, String senha) {
        for (Funcionario f : funcionarios) {
            if (f.login(usuario, senha)) {
                return true;
            }
        }
        return false;
    }

    public void logoutTodos() {
        for (Funcionario f : funcionarios) {
            f.logout();
        }
    }

    public void cadastrarFuncionario(Funcionario f) {
        funcionarios.add(f);
        dao.salvar(funcionarios);
    }

    public List<Funcionario> listar() {
        return funcionarios;
    }
}
