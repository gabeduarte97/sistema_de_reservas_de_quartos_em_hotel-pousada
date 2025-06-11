package controller;

import dao.ReservaDAO;
import model.Hospede;
import model.Quarto;
import model.Reserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservaController {
    private List<Reserva> reservas;
    private ReservaDAO dao;

    public ReservaController() {
        dao = new ReservaDAO();
        reservas = dao.carregar();
        if (reservas == null) {
            reservas = new ArrayList<>();
        }
    }


    public void reservar(Reserva r) {
        reservas.add(r);
        dao.salvar(reservas);
    }

    public void reservar(Hospede h, Quarto q, LocalDate data) {
        Reserva r = new Reserva(h, q, data);
        reservar(r);
    }

    
    public void reservar(Hospede h, Quarto q, String dataStr) {
        LocalDate data = LocalDate.parse(dataStr);
        reservar(h, q, data);
    }

  
    public List<Reserva> listar() {
        return reservas;
    }

    public boolean removerReserva(Reserva r) {
        boolean removido = reservas.remove(r);
        if (removido) {
            dao.salvar(reservas);
        }
        return removido;
    }
}
