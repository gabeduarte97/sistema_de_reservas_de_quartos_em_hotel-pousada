package util;

import model.Funcionario;

import java.io.*;
import java.util.List;

public class Serializador {

  
    public static void salvar(String caminho, List lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(lista);
            Logger.log("Dados salvos em " + caminho);
        } catch (IOException e) {
            Logger.log("Erro ao salvar dados: " + e.getMessage());
        }
    }

    public static List carregar(String caminho) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            return (List) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            Logger.log("Erro ao carregar dados: " + e.getMessage());
            return null;
        }
    }


    public static void salvarFuncionario(String caminho, List funcionarios) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(funcionarios);
            Logger.log("Funcionários salvos em " + caminho);
        } catch (IOException e) {
            Logger.log("Erro ao salvar funcionários: " + e.getMessage());
        }
    }

    public static List<Funcionario> carregarFuncionario(String caminho) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            return (List<Funcionario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            Logger.log("Erro ao carregar funcionários: " + e.getMessage());
            return null;
        }
    }
}
