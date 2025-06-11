package dao;

import model.Quarto;
import util.Serializador;

import java.util.List;

public class QuartoDAO {
    private final String arquivo = "dados/quartos.ser";

    public void salvar(List<Quarto> quartos) {
        Serializador.salvar(arquivo, quartos);
    }

    @SuppressWarnings("unchecked")
    public List<Quarto> carregar() {
        return (List<Quarto>) Serializador.carregar(arquivo);
    }
}
