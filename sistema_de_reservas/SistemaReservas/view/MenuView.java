package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int menuPrincipal() {
        System.out.println("\n=== SISTEMA DE RESERVAS DE HOTEL ===");
        System.out.println("1. Gerenciar Hóspedes");
        System.out.println("2. Gerenciar Quartos");
        System.out.println("3. Gerenciar Reservas");
        System.out.println("0. Sair");
        return lerOpcao();
    }

    public static int menuCrud(String entidade) {
        System.out.println("\n=== " + entidade.toUpperCase() + " ===");
        System.out.println("1. Cadastrar " + entidade);
        System.out.println("2. Listar " + entidade + "s");
        if (entidade.equalsIgnoreCase("Quarto")) {
            System.out.println("3. Exibir diárias dos quartos");
        }
        System.out.println("0. Voltar");
        return lerOpcao();
    }

    public static Scanner getScanner() {
        return scanner;
    }

    private static int lerOpcao() {
        int opcao = -1;
        boolean valido = false;

        while (!valido) {
            System.out.print("Escolha uma opção: ");
            try {
                opcao = scanner.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.nextLine(); // limpa buffer
            }
        }

        return opcao;
    }
}
