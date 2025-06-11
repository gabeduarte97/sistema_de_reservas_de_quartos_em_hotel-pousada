package dao;

import model.Hospede;
import util.Serializador;

import java.util.List;

public class HospedeDAO {
    private final String arquivo = "dados/hospedes.ser";

    public void salvar(List<Hospede> hospedes) {
        Serializador.salvar(arquivo, hospedes);
    }

    @SuppressWarnings("unchecked")
    public List<Hospede> carregar() {
        return (List<Hospede>) Serializador.carregar(arquivo);
    }
}
