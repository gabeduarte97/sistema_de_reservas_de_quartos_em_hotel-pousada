
package controller;

import model.Quarto;
import util.Serializador;
import java.util.ArrayList;
import java.util.List;

public class QuartoController {
    private List<Quarto> quartos;
    private final String arquivo = "dados/quartos.ser";

    public QuartoController() {
        quartos = Serializador.carregar(arquivo);
        if (quartos == null) quartos = new ArrayList<>();
    }

    public void cadastrarQuarto(Quarto q) {
        quartos.add(q);
        Serializador.salvar(arquivo, quartos);
    }

    public List<Quarto> listar() {
        return quartos;
    }
}
