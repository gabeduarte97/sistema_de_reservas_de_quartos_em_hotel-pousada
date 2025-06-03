package controller;

import model.*;

import java.time.LocalDate;

public class ReservaFactory {
    public static Reserva criarReserva(Hospede hospede, Quarto quarto, LocalDate data) {
        return new Reserva(hospede, quarto, data);
    }
}