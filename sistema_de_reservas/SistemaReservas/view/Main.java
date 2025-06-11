package view;

import controller.HospedeController;
import controller.QuartoController;
import controller.ReservaController;
import factory.HospedeFactory;
import factory.QuartoFactory;
import factory.ReservaFactory;
import model.Funcionario;
import model.Hospede;
import model.Quarto;
import model.Reserva;
import util.PreCarga;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HospedeController hc = new HospedeController();
        QuartoController qc = new QuartoController();
        ReservaController rc = new ReservaController();
        Scanner sc = MenuView.getScanner();

        // ==== PRÉ-CARGA DE DADOS ====
        PreCarga.executar(hc, qc, rc);

        // ==== LOGIN ====
        Funcionario funcionario = new Funcionario("Admin", "00000000000", "admin123", "senha123");

        System.out.println("=== LOGIN DO FUNCIONÁRIO ===");
        System.out.print("Matrícula: ");
        String usuario = sc.next();
        System.out.print("Senha: ");
        String senha = sc.next();

        if (!funcionario.login(usuario, senha)) {
            System.out.println("Acesso negado. Encerrando sistema.");
            return;
        }

        System.out.println("Login bem-sucedido!\n");

        // ==== MENU PRINCIPAL ====
        int opcao;
        do {
            opcao = MenuView.menuPrincipal();
            switch (opcao) {

                case 1: // CRUD HÓSPEDE
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
                            try {
                                Hospede h = HospedeFactory.criarHospede(nome, cpf, tel);
                                hc.cadastrarHospede(h);
                                System.out.println("Hóspede cadastrado!");
                            } catch (IllegalArgumentException e) {
                                System.out.println("Erro ao cadastrar hóspede: " + e.getMessage());
                            }
                        } else if (opH == 2) {
                            for (Hospede h : hc.listar()) {
                                System.out.println(h);
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

                case 2: // CRUD QUARTO
                    int opQ;
                    do {
                        opQ = MenuView.menuCrud("Quarto");
                        if (opQ == 1) {
                            System.out.print("Número: ");
                            int num = sc.nextInt();
                            System.out.print("Capacidade: ");
                            int cap = sc.nextInt();
                            System.out.print("Tipo (1 - Simples | 2 - Luxo): ");
                            int tipo = sc.nextInt();

                            try {
                                Quarto q;
                                if (tipo == 1) {
                                    q = QuartoFactory.criarQuartoSimples(num, cap);
                                } else if (tipo == 2) {
                                    q = QuartoFactory.criarQuartoLuxo(num, cap);
                                } else {
                                    System.out.println("Tipo inválido. Cadastro cancelado.");
                                    continue;
                                }

                                qc.cadastrarQuarto(q);
                                System.out.println("Quarto cadastrado com sucesso!");
                            } catch (IllegalArgumentException e) {
                                System.out.println("Erro ao cadastrar quarto: " + e.getMessage());
                            }
                        } else if (opQ == 2) {
                            for (Quarto q : qc.listar()) {
                                System.out.println(q);
                            }
                        } else if (opQ == 3) {
                            System.out.println("\n=== DIÁRIAS DOS QUARTOS ===");
                            for (Quarto q : qc.listar()) {
                                System.out.println(q + " | Diária: R$ " + q.calcularDiaria());
                            }
                        }
                    } while (opQ != 0);
                    break;

                case 3: // CRUD RESERVA
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
                            System.out.print("CPF do hóspede: ");
                            String cpf = sc.next();

                            Hospede hospedeCadastrado = null;
                            for (Hospede h : hc.listar()) {
                                if (h.getCpf().equals(cpf)) {
                                    hospedeCadastrado = h;
                                    break;
                                }
                            }

                            if (hospedeCadastrado == null) {
                                System.out.println("Hóspede com esse CPF não está cadastrado.");
                                break;
                            }

                            System.out.print("Número do quarto: ");
                            int numero = sc.nextInt();

                            Quarto quartoCadastrado = null;
                            for (Quarto q : qc.listar()) {
                                if (q.getNumero() == numero) {
                                    quartoCadastrado = q;
                                    break;
                                }
                            }

                            if (quartoCadastrado == null) {
                                System.out.println("Quarto com esse número não está cadastrado.");
                                break;
                            }

                            System.out.print("Data da reserva (AAAA-MM-DD): ");
                            String dataStr = sc.next();

                            try {
                                Reserva r = ReservaFactory.criarReserva(
                                        hospedeCadastrado.getNome(),
                                        hospedeCadastrado.getCpf(),
                                        hospedeCadastrado.getTelefone(),
                                        quartoCadastrado,
                                        dataStr
                                );
                                rc.reservar(r);
                                System.out.println("Reserva realizada com sucesso!");
                            } catch (IllegalArgumentException e) {
                                System.out.println("Erro ao realizar reserva: " + e.getMessage());
                            }

                        } else if (opR == 2) {
                            for (Reserva r : rc.listar()) {
                                System.out.println(r);
                            }
                        } else if (opR == 3) {
                            System.out.print("CPF do hóspede: ");
                            String cpf = sc.next();
                            System.out.print("Número do quarto: ");
                            int numero = sc.nextInt();
                            System.out.print("Data da reserva (AAAA-MM-DD): ");
                            String dataStr = sc.next();

                            try {
                                LocalDate data = LocalDate.parse(dataStr);
                                Hospede h = HospedeFactory.criarHospede("temp", cpf, "00000000000");
                                Quarto q = QuartoFactory.criarQuartoSimples(numero, 1);
                                Reserva r = new Reserva(h, q, data);

                                if (rc.removerReserva(r)) {
                                    System.out.println("Reserva removida com sucesso.");
                                } else {
                                    System.out.println("Reserva não encontrada.");
                                }
                            } catch (Exception e) {
                                System.out.println("Erro: " + e.getMessage());
                            }
                        }
                    } while (opR != 0);
                    break;
            }
        } while (opcao != 0);

        System.out.println("Sistema encerrado.");
    }
}
