package factory;

import model.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ReservaFactory {

    public static Reserva criarReserva(Hospede hospede, Quarto quarto, LocalDate data) {
        if (hospede == null || quarto == null || data == null) {
            throw new IllegalArgumentException("Dados inválidos para criar a reserva.");
        }
        return new Reserva(hospede, quarto, data);
    }

    public static Reserva criarReserva(String nome, String cpf, String telefone, Quarto quarto, String dataStr) {
        try {
            LocalDate data = LocalDate.parse(dataStr);
            Hospede h = new Hospede(nome, cpf, telefone);
            return criarReserva(h, quarto, data);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de data inválido. Use AAAA-MM-DD.");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Erro ao criar hóspede: " + e.getMessage());
        }
    }
}
