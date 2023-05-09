package br.edu.ifpr.persistproject.connection;

import br.edu.ifpr.persistproject.model.Seller;
import br.edu.ifpr.persistproject.repository.SellerRepository;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ConnectionTest {

    public static void main(String[] args) {

        SellerRepository repository = new SellerRepository();

        Seller seller = new Seller();
        seller.setName("Maria");
        seller.setBaseSalary(5000.0);

        repository.insert(seller);

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
