package util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;

public final class Logger {
    private static final String LOG_FILE = "log.txt";

    private Logger() {}

    public static void log(String mensagem) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write("[" + LocalTime.now() + "] " + mensagem + "\n");
        } catch (IOException e) {
            System.err.println("Erro ao escrever log: " + e.getMessage());
        }
    }
}