package pl.sda.springecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import pl.sda.springecommerce.dao.ProductRepo;
import pl.sda.springecommerce.model.Product;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DbInit implements CommandLineRunner {

    private final ProductRepo productRepo;

    @Autowired
    public DbInit(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        productRepo.saveAll(List.of(
                new Product("Piggy Bank", new BigDecimal(7.50), "https://m.media-amazon.com/images/I/51ckv2myWXL.jpg"),
                new Product("Black cat", new BigDecimal(8.50), "https://www.rd.com/wp-content/uploads/2021/01/GettyImages-1175550351.jpg"),
                new Product("Porky", new BigDecimal(9.50), "https://icdn.2cda.pl/g/122975_147752136690542103.jpg")
        ));
    }
}
