package controller;

import dao.HospedeDAO;
import model.Hospede;

import java.util.ArrayList;
import java.util.List;

public class HospedeController {
    private List<Hospede> hospedes;
    private final HospedeDAO dao;

    public HospedeController() {
        dao = new HospedeDAO();
        hospedes = dao.carregar();
        if (hospedes == null) hospedes = new ArrayList<>();
    }

    public void cadastrarHospede(Hospede h) {
        hospedes.add(h);
        dao.salvar(hospedes);
    }

    public List<Hospede> listar() {
        return hospedes;
    }

    public boolean removerPorCpf(String cpf) {
        boolean removido = hospedes.removeIf(h -> h.getCpf().equals(cpf));
        if (removido) {
            dao.salvar(hospedes);
        }
        return removido;
    }

    public boolean atualizarTelefone(String cpf, String novoTelefone) {
        for (Hospede h : hospedes) {
            if (h.getCpf().equals(cpf)) {
                h.setTelefone(novoTelefone);
                dao.salvar(hospedes);
                return true;
            }
        }
        return false;
    }
}
