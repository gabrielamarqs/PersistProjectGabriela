package br.edu.ifpr.persistproject.connection;

import br.edu.ifpr.persistproject.exception.DatabaseIntegrityException;

import java.sql.*;

public class ConnectionFactory {

    public Connection getConnection(){

        // está retornando uma conexão

        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/ifpr_store", "gabriela", "daniela");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void statementClose(Statement statement) {
        // para fechar a statement
        try {
            statement.close();
        } catch (SQLException e) {
            throw new DatabaseIntegrityException(e.getMessage());
        }
    }

    public static void resultSetClose(ResultSet resultSet) {
        // para fechar a statement
        try {
            resultSet.close();
        } catch (SQLException e) {
            throw new DatabaseIntegrityException(e.getMessage());
        }

    }
}
