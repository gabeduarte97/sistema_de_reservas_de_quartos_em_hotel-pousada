package controller;

import dao.QuartoDAO;
import model.Quarto;

import java.util.ArrayList;
import java.util.List;

public class QuartoController {
    private List<Quarto> quartos;
    private final QuartoDAO dao;

    public QuartoController() {
        dao = new QuartoDAO();
        quartos = dao.carregar();
        if (quartos == null) quartos = new ArrayList<>();
    }

    public void cadastrarQuarto(Quarto q) {
        quartos.add(q);
        dao.salvar(quartos);
    }

    public List<Quarto> listar() {
        return quartos;
    }
}
