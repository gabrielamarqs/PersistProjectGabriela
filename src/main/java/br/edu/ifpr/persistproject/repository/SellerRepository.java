package br.edu.ifpr.persistproject.repository;

import br.edu.ifpr.persistproject.connection.ConnectionFactory;
import br.edu.ifpr.persistproject.model.Seller;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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


        // metodo que vai obter todos os nossos vendedores do nosso banco de dados

        Statement statement = null;
        // objeto que consegue executar operações do banco de dados
        // executar as query

        ResultSet resultSet = null;
        // é o resultado da consulta em formato de tabela

        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM seller");
            // executeQuery - consulta
            // executeUpdate - inserir alguma coisa asism

            while (resultSet.next()){
                Seller seller = new Seller();

                seller.setId(resultSet.getInt("Id"));
                seller.setName(resultSet.getString("Name"));
                seller.setEmail(resultSet.getString("Email"));
                seller.setBaseSalary(resultSet.getDouble("baseSalary"));
                seller.setBirthDate(resultSet.getDate("birthDate").toLocalDate());
                // vai transformar nossos dados do banco de dados em dados que o java entende (objetos)

                sellers.add(seller);
                // toda vez que passar pelo while vai adicionar cada objeto criado na lista

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            // em vez de por um try catch em todas as classes
            // melhor fazer um método que faz isso para a gente

            ConnectionFactory.resultSetClose(resultSet);
            ConnectionFactory.statementClose(statement);

        }

        return sellers;
        // vai retornar uma lista sellers que vem do banco de dados
    }

    public Seller insert(Seller seller) {
        // seller passado como parÂmetro
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // eh porque esse objeto não existe e precisamos criar um novo
        // essa responsabilidade é nossa

        // porque alguns objetos precimos estanciar e outros não?

        PreparedStatement statement = null;

        try {
            statement = conn.prepareStatement("INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES (?, ?, ?, ?, ?);", PreparedStatement.RETURN_GENERATED_KEYS);
            // essa consulta vai nos retornar os ids que foram inseridos nessa consulta

            // o prepareStatemente cria o objeto pra nós
            // e nos retorna o objeto criado

            statement.setString(1, seller.getName());
            // seller é o objeto seller
            // primeiro valor se refere a primeira interrogação
            statement.setString(2, seller.getEmail());
            statement.setDate(3, new Date(dateFormat.parse("17/15/1999").getTime()));
            // fazer a conversão para local date
            statement.setDouble(4, seller.getBaseSalary());
            statement.setInt(5, 2);

            Integer rowsAffected = statement.executeUpdate();
            // usado para alterar o banco de dados
            // retorna o numero de linhas que foi executado

            if (rowsAffected > 0) {

                ResultSet keys = statement.getGeneratedKeys();
                // retorna um result set
                // dado em formato de tabela
                // retorna uma lista dos elementos que foram inseridos
                keys.next();
                // vai pra próxima linha
                Integer id = keys.getInt(1);
                // pega a informação que está na primeira coluna

                seller.setId(id);

                System.out.println("Done!" + rowsAffected + "rows affected");
                System.out.println("Id generated: " + id);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.statementClose(statement);
        }

        return seller;
        // retorna seller
    }

}
