
package model;

import interfaces.Autenticavel;

public class Funcionario extends Pessoa implements Autenticavel {
    private String matricula;
    private String senha;

    public Funcionario(String nome, String cpf, String matricula, String senha) {
        super(nome, cpf);
        this.matricula = matricula;
        this.senha = senha;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public boolean login(String usuario, String senha) {
        return this.matricula.equals(usuario) && this.senha.equals(senha);
    }

    @Override
    public void logout() {
        
    }
}
