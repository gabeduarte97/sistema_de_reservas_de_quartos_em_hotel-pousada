package model;

public class QuartoSimples extends Quarto {
    public QuartoSimples(int numero, int capacidade) {
        super(numero, capacidade);
    }

    @Override
    public double calcularDiaria() {
        return 100.0;
    }

    @Override
    public String toString() {
        return "Quarto Simples - Número: " + getNumero() + ", Capacidade: " + getCapacidade();
    }
}
