package controller;

import model.Hospede;
import util.Serializador;
import java.util.ArrayList;
import java.util.List;

public class HospedeController {
    private List<Hospede> hospedes;
    private final String arquivo = "dados/hospedes.ser";

    public HospedeController() {
        hospedes = Serializador.carregar(arquivo);
        if (hospedes == null) hospedes = new ArrayList<>();
    }

    public void cadastrarHospede(Hospede h) {
        hospedes.add(h);
        Serializador.salvar(arquivo, hospedes);
    }

    public List<Hospede> listar() {
        return hospedes;
    }

    public boolean removerPorCpf(String cpf) {
        boolean removido = hospedes.removeIf(h -> h.getCpf().equals(cpf));
        if (removido) {
            Serializador.salvar(arquivo, hospedes);
        }
        return removido;
    }

    // Opcional: método de atualização
    public boolean atualizarTelefone(String cpf, String novoTelefone) {
        for (Hospede h : hospedes) {
            if (h.getCpf().equals(cpf)) {
                h.setTelefone(novoTelefone);
                Serializador.salvar(arquivo, hospedes);
                return true;
            }
        }
        return false;
    }
}
