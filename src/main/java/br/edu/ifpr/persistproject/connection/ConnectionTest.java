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
        seller.setName("Jennie");
        seller.setEmail("jj@gmail.com");
        seller.setBaseSalary(1800000.0);
        repository.insert(seller);
        List<Seller> sellers = repository.getSellers();
        // metodo repository tem varios metodos

        sellers.forEach( s -> System.out.println(s) );

        // imprime um objeto da classe seller que é o tostring

        // programação funcional
    }

}
