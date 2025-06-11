package util;

import controller.HospedeController;
import controller.QuartoController;
import controller.ReservaController;
import factory.HospedeFactory;
import factory.QuartoFactory;
import factory.ReservaFactory;
import model.Hospede;
import model.Quarto;
import model.Reserva;

public class PreCarga {

    public static void executar(HospedeController hc, QuartoController qc, ReservaController rc) {

        if (hc.listar().isEmpty()) {
            try {
                Hospede h1 = HospedeFactory.criarHospede("Carlos", "11111111111", "11999999999");
                Hospede h2 = HospedeFactory.criarHospede("Ana", "22222222222", "21988888888");
                hc.cadastrarHospede(h1);
                hc.cadastrarHospede(h2);
            } catch (IllegalArgumentException e) {
                System.out.println("Erro na pré-carga de hóspedes: " + e.getMessage());
            }
        }

        if (qc.listar().isEmpty()) {
            try {
                Quarto q1 = QuartoFactory.criarQuartoSimples(101, 2);
                Quarto q2 = QuartoFactory.criarQuartoLuxo(202, 4);
                qc.cadastrarQuarto(q1);
                qc.cadastrarQuarto(q2);
            } catch (IllegalArgumentException e) {
                System.out.println("Erro na pré-carga de quartos: " + e.getMessage());
            }
        }

        if (rc.listar().isEmpty()) {
            try {
                Reserva r1 = ReservaFactory.criarReserva("Carlos", "11111111111", "11999999999",
                        QuartoFactory.criarQuartoSimples(101, 2), "2025-06-20");

                Reserva r2 = ReservaFactory.criarReserva("Ana", "22222222222", "21988888888",
                        QuartoFactory.criarQuartoLuxo(202, 4), "2025-06-22");

                rc.reservar(r1);
                rc.reservar(r2);
            } catch (Exception e) {
                System.out.println("Erro na pré-carga de reservas: " + e.getMessage());
            }
        }

        System.out.println("[Pré-carga executada com sucesso]\n");
    }
}
