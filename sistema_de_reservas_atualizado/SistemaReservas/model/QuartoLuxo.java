package model;

public class QuartoLuxo extends Quarto {
    public QuartoLuxo(int numero, int capacidade) {
        super(numero, capacidade);
    }

    @Override
    public double calcularDiaria() {
        return 250.0;
    }

    @Override
    public String toString() {
        return "Quarto Luxo - " + super.toString();
    }
}