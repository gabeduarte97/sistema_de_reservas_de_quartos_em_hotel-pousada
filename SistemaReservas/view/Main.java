/*Integrantes:
Gabriel Duarte Morato 
RGM:38370620

Natália de Oliveira Santos
RGM: 37482971

Hipólito Alexandre Ribeiro da Silva
RGM: 37762231

Matheus Guilherme Correia Seara 
RGM: 38365278

/* */

package view;

import controller.HospedeController;
import controller.QuartoController;
import controller.ReservaController;
import model.Hospede;
import model.Quarto;
import model.QuartoSimples;
import model.Reserva;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HospedeController hc = new HospedeController();
        QuartoController qc = new QuartoController();
        ReservaController rc = new ReservaController();
        Scanner sc = MenuView.getScanner();
        int opcao;

        do {
            opcao = MenuView.menuPrincipal();
            switch (opcao) {
                case 1:
                    int opH;
                    do {
                        System.out.println("\n=== HÓSPEDE ===");
                        System.out.println("1. Cadastrar hóspede");
                        System.out.println("2. Listar hóspedes");
                        System.out.println("3. Remover hóspede por CPF");
                        System.out.println("0. Voltar");
                        System.out.print("Escolha uma opção: ");
                        opH = sc.nextInt();

                        if (opH == 1) {
                            System.out.print("Nome: ");
                            String nome = sc.next();
                            System.out.print("CPF: ");
                            String cpf = sc.next();
                            System.out.print("Telefone: ");
                            String tel = sc.next();
                            hc.cadastrarHospede(new Hospede(nome, cpf, tel));
                            System.out.println("Hóspede cadastrado!");
                        } else if (opH == 2) {
                            for (Hospede h : hc.listar()) {
                                System.out.println(h.getNome() + " - " + h.getCpf() + " - " + h.getTelefone());
                            }
                        } else if (opH == 3) {
                            System.out.print("Digite o CPF do hóspede a remover: ");
                            String cpf = sc.next();
                            if (hc.removerPorCpf(cpf)) {
                                System.out.println("Hóspede removido com sucesso.");
                            } else {
                                System.out.println("Hóspede com esse CPF não encontrado.");
                            }
                        }
                    } while (opH != 0);
                    break;

                case 2:
                    int opQ;
                    do {
                        opQ = MenuView.menuCrud("Quarto");
                        if (opQ == 1) {
                            System.out.print("Número: ");
                            int num = sc.nextInt();
                            System.out.print("Capacidade: ");
                            int cap = sc.nextInt();
                            qc.cadastrarQuarto(new QuartoSimples(num, cap));
                            System.out.println("Quarto cadastrado!");
                        } else if (opQ == 2) {
                            for (Quarto q : qc.listar()) {
                                System.out.println("Quarto " + q.getNumero() + " - Capacidade: " + q.getCapacidade());
                            }
                        }
                    } while (opQ != 0);
                    break;

                case 3:
                    int opR;
                    do {
                        System.out.println("\n=== RESERVA ===");
                        System.out.println("1. Cadastrar reserva");
                        System.out.println("2. Listar reservas");
                        System.out.println("3. Remover reserva");
                        System.out.println("0. Voltar");
                        System.out.print("Escolha uma opção: ");
                        opR = sc.nextInt();

                        if (opR == 1) {
                            System.out.print("Nome do hóspede: ");
                            String nome = sc.next();
                            System.out.print("CPF: ");
                            String cpf = sc.next();
                            System.out.print("Telefone: ");
                            String tel = sc.next();
                            System.out.print("Número do quarto: ");
                            int numero = sc.nextInt();
                            System.out.print("Capacidade do quarto: ");
                            int capacidade = sc.nextInt();

                            Hospede h = new Hospede(nome, cpf, tel);
                            Quarto q = new QuartoSimples(numero, capacidade);
                            rc.reservar(new Reserva(h, q, LocalDate.now()));
                            System.out.println("Reserva realizada!");
                        } else if (opR == 2) {
                            for (Reserva r : rc.listar()) {
                                System.out.println("Reserva de " + r.getHospede().getNome() + " no quarto " + r.getQuarto().getNumero());
                            }
                        } else if (opR == 3) {
                            System.out.print("CPF do hóspede: ");
                            String cpf = sc.next();
                            System.out.print("Número do quarto: ");
                            int numero = sc.nextInt();
                            System.out.print("Data da reserva (AAAA-MM-DD): ");
                            String dataStr = sc.next();
                            LocalDate data = LocalDate.parse(dataStr);

                            Hospede h = new Hospede("temp", cpf, "temp"); // Dados irrelevantes para equals
                            Quarto q = new QuartoSimples(numero, 1);
                            Reserva r = new Reserva(h, q, data);

                            if (rc.removerReserva(r)) {
                                System.out.println("Reserva removida com sucesso.");
                            } else {
                                System.out.println("Reserva não encontrada.");
                            }
                        }
                    } while (opR != 0);
                    break;
            }
        } while (opcao != 0);

        System.out.println("Sistema encerrado.");
    }
}
