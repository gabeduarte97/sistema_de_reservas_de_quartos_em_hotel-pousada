package controller;

import model.Reserva;
import util.Serializador;
import java.util.ArrayList;
import java.util.List;

public class ReservaController {
    private List<Reserva> reservas;
    private final String arquivo = "dados/reservas.ser";

    public ReservaController() {
        reservas = Serializador.carregar(arquivo);
        if (reservas == null) reservas = new ArrayList<>();
    }

    public void reservar(Reserva r) {
        reservas.add(r);
        Serializador.salvar(arquivo, reservas);
    }

    // Polimorfismo de sobrecarga
    public void reservar(Reserva r, boolean urgente) {
        if (urgente) System.out.println("Reserva marcada como urgente!");
        reservar(r);
    }

    public List<Reserva> listar() {
        return reservas;
    }

    public boolean removerReserva(Reserva r) {
        boolean removido = reservas.remove(r);
        if (removido) {
            Serializador.salvar(arquivo, reservas);
        }
        return removido;
    }
}
