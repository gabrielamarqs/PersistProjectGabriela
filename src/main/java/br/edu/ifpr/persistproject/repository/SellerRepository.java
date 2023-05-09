package br.edu.ifpr.persistproject.repository;

import br.edu.ifpr.persistproject.connection.ConnectionFactory;
import br.edu.ifpr.persistproject.model.Seller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SellerRepository {

    private Connection conn;

    public SellerRepository(){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        conn = connectionFactory.getConnection();
    }

    public List<Seller> getSellers(){

        List<Seller> sellers = new ArrayList<>();

        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM seller");

            while (resultSet.next()){
                Seller seller = new Seller();

                seller.setId(resultSet.getInt("Id"));
                seller.setName(resultSet.getString("Name"));
                seller.setBaseSalary(resultSet.getDouble("BaseSalary"));
                seller.setBirthDate(resultSet.getDate("BirthDate").toLocalDate());

                sellers.add(seller);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            ConnectionFactory.resultSetClose(resultSet);
            ConnectionFactory.statementClose(statement);
        }

        return sellers;

    }


}
