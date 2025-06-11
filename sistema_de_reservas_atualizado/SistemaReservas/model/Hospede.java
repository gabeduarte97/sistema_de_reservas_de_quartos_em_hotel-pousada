package model;

public class Hospede extends Pessoa {
    private String telefone;

    public Hospede(String nome, String cpf, String telefone) {
        super(nome, cpf);
        setTelefone(telefone);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone != null && telefone.matches("\\d{11}")) {
            this.telefone = telefone;
        } else {
            throw new IllegalArgumentException("Telefone deve conter exatamente 11 dígitos (com DDD).");
        }
    }

    @Override
    public String toString() {
        return "Hóspede: " + getNome() + ", CPF: " + getCpf() + ", Tel: " + telefone;
    }

}
