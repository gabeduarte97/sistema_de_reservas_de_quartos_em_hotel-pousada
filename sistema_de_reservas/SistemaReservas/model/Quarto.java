package model;

import java.io.Serializable;

public abstract class Quarto implements Reservavel, Serializable {
    private int numero;
    private int capacidade;

    public Quarto(int numero, int capacidade) {
        this.numero = numero;
        this.capacidade = capacidade;
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    // Método abstrato herdado da interface Reservavel
    @Override
    public abstract double calcularDiaria();

    @Override
    public String toString() {
        return "Número: " + numero + ", Capacidade: " + capacidade;
    }

    // equals e hashCode baseados no número do quarto (para remover corretamente)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quarto)) return false;
        Quarto outro = (Quarto) obj;
        return this.numero == outro.numero;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(numero);
    }
}
