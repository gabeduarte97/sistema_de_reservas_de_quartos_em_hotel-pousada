
package util;

import java.io.*;
import java.util.List;

public class Serializador {

    public static <T> void salvar(String caminho, List<T> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(lista);
            Logger.log("Dados salvos em " + caminho);
        } catch (IOException e) {
            Logger.log("Erro ao salvar dados: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> carregar(String caminho) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            Logger.log("Erro ao carregar dados: " + e.getMessage());
            return null;
        }
    }
}
