
package view;

import java.util.Scanner;

public class MenuView {
    private static Scanner scanner = new Scanner(System.in);

    public static int menuPrincipal() {
        System.out.println("=== SISTEMA DE RESERVAS DE HOTEL ===");
        System.out.println("1. Gerenciar Hóspedes");
        System.out.println("2. Gerenciar Quartos");
        System.out.println("3. Gerenciar Reservas");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public static int menuCrud(String entidade) {
        System.out.println("\n=== " + entidade.toUpperCase() + " ===");
        System.out.println("1. Cadastrar " + entidade);
        System.out.println("2. Listar " + entidade + "s");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public static Scanner getScanner() {
        return scanner;
    }
}
