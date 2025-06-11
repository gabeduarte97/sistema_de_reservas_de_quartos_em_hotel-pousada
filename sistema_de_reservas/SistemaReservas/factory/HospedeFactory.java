package factory;

import model.Hospede;

public class HospedeFactory {

    public static Hospede criarHospede(String nome, String cpf, String telefone) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do hóspede não pode estar em branco.");
        }

        if (cpf == null || !cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF deve conter exatamente 11 dígitos numéricos.");
        }

        if (telefone == null || !telefone.matches("\\d{11}")) {
            throw new IllegalArgumentException("Telefone deve conter exatamente 11 dígitos (com DDD).");
        }

        return new Hospede(nome, cpf, telefone);
    }
}
