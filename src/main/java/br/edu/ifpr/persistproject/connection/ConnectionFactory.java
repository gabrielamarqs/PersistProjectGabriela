package br.edu.ifpr.persistproject.connection;

import br.edu.ifpr.persistproject.exception.DatabaseIntegrityException;

import java.sql.*;

public class ConnectionFactory {

    public Connection getConnection(){

        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/ifpr_store", "root", "bancodedados");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void statementClose(Statement statement){
        try {
            statement.close();
        } catch (SQLException e) {
            throw new DatabaseIntegrityException(e.getMessage());
        }
    }

    public static void resultSetClose(ResultSet resultSet){
        try {
            resultSet.close();
        } catch (SQLException e) {
            throw new DatabaseIntegrityException(e.getMessage());
        }
    }

}
