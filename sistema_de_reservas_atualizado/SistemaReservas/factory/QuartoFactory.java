package factory;

import model.QuartoSimples;
import model.Quarto;

public class QuartoFactory {

    public static Quarto criarQuartoSimples(int numero, int capacidade) {
        if (numero <= 0) {
            throw new IllegalArgumentException("Número do quarto deve ser maior que zero.");
        }

        if (capacidade <= 0) {
            throw new IllegalArgumentException("Capacidade deve ser maior que zero.");
        }

        return new QuartoSimples(numero, capacidade);
    }
}
