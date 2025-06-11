package model;

import java.io.Serializable;
import java.util.Objects;

public abstract class Quarto implements Reservavel, Serializable {
    protected int numero;
    protected int capacidade;

    public Quarto(int numero, int capacidade) {
        this.numero = numero;
        this.capacidade = capacidade;
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public int getCapacidade() { return capacidade; }
    public void setCapacidade(int capacidade) { this.capacidade = capacidade; }

    @Override
    public String toString() {
        return "Quarto número " + numero + ", capacidade: " + capacidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quarto)) return false;
        Quarto quarto = (Quarto) o;
        return numero == quarto.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}
