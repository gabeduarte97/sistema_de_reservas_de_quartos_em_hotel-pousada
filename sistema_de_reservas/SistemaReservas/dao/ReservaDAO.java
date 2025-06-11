package dao;

import model.Reserva;
import util.Serializador;
import java.util.List;

public class ReservaDAO {
    private final String arquivo = "dados/reservas.ser";

    public void salvar(List<Reserva> reservas) {
        Serializador.salvar(arquivo, reservas);
    }

    @SuppressWarnings("unchecked")
    public List<Reserva> carregar() {
        return (List<Reserva>) Serializador.carregar(arquivo);
    }
}
