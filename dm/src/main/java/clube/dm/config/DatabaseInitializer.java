package clube.dm.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void criarBancoSeNaoExistir() {
        String url = "jdbc:postgresql://localhost:5432/";
        String user = "postgres";
        String password = "postgres";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT 1 FROM pg_database WHERE datname = 'dm'");
            if (!rs.next()) {
                stmt.executeUpdate("CREATE DATABASE dm");
                System.out.println("Banco de dados 'dm' criado com sucesso.");
            } else {
                System.out.println("Banco de dados 'dm' já existe.");
            }

        } catch (Exception e) {
            System.err.println("Erro ao criar banco de dados: " + e.getMessage());
        }
    }
}