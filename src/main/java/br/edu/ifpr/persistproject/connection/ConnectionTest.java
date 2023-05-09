package br.edu.ifpr.persistproject.connection;

import br.edu.ifpr.persistproject.model.Seller;
import br.edu.ifpr.persistproject.repository.SellerRepository;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ConnectionTest {

    public static void main(String[] args) {

        SellerRepository repository = new SellerRepository();

        List<Seller> sellers = repository.getSellers();

        sellers.forEach( s -> System.out.println(s) );

        /*
        O comando acima é análogo ao for abaixo
        for (Seller s: sellers){
            System.out.println(s);
        }
        */

    }

}
