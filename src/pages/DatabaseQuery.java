package pages;
import java.sql.*;

public class DatabaseQuery {
    // Configurações do banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/radios";
    private static final String USERNAME = "radiosuser";
    private static final String PASSWORD = "radiosuser";

    public static String buscaDB(String query, String coluna) {
        String retorno = "";
        try {
            // Carrega o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Cria a conexão com o banco de dados
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Cria a declaração SQL
            Statement statement = connection.createStatement();

            // Executa a consulta SQL
            ResultSet resultSet = statement.executeQuery(query);

            // Processa o resultado da consulta
            while (resultSet.next()) {
                // Obtém os valores das colunas
                retorno = resultSet.getString(coluna);
            }

            // Fecha os recursos
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        if (retorno == "" & coluna.equals("nome")) {
            retorno = "UNKNOWN";
        }
        else if (retorno == "" & coluna.equals("path")) {
            retorno = "./lib/sound/midias/chiado.wav";
        }
        return retorno;
    }

}


