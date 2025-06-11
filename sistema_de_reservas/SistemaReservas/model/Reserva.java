package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Reserva implements Serializable {
    private Hospede hospede;
    private Quarto quarto;
    private LocalDate data;
    private StatusReserva status;

    public Reserva(Hospede hospede, Quarto quarto, LocalDate data) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.data = data;
        this.status = StatusReserva.ATIVA;
    }

    public Hospede getHospede() { return hospede; }
    public Quarto getQuarto() { return quarto; }
    public LocalDate getData() { return data; }
    public StatusReserva getStatus() { return status; }
    public void setStatus(StatusReserva status) { this.status = status; }

    @Override
    public String toString() {
        return "Reserva: " + hospede.getNome() + " - " + quarto.toString() +
               " - Data: " + data + " - Status: " + status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reserva)) return false;
        Reserva reserva = (Reserva) o;
        return hospede.getCpf().equals(reserva.hospede.getCpf()) &&
               quarto.getNumero() == reserva.quarto.getNumero() &&
               data.equals(reserva.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hospede.getCpf(), quarto.getNumero(), data);
    }
}
