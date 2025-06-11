package factory;

import model.Quarto;
import model.QuartoSimples;
import model.QuartoLuxo;

public class QuartoFactory {

    public static Quarto criarQuartoSimples(int numero, int capacidade) {
        validarDados(numero, capacidade);
        return new QuartoSimples(numero, capacidade);
    }

    public static Quarto criarQuartoLuxo(int numero, int capacidade) {
        validarDados(numero, capacidade);
        return new QuartoLuxo(numero, capacidade);
    }

    private static void validarDados(int numero, int capacidade) {
        if (numero <= 0) {
            throw new IllegalArgumentException("Número do quarto deve ser maior que zero.");
        }

        if (capacidade <= 0) {
            throw new IllegalArgumentException("Capacidade deve ser maior que zero.");
        }
    }
}
