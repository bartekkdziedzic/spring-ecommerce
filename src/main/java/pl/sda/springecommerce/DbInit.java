package pl.sda.springecommerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.sda.springecommerce.model.Category;
import pl.sda.springecommerce.model.Product;
import pl.sda.springecommerce.model.Role;
import pl.sda.springecommerce.model.UserEntity;
import pl.sda.springecommerce.repository.ProductRepo;
import pl.sda.springecommerce.repository.UserRepo;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DbInit implements CommandLineRunner {

    private final ProductRepo productRepo;

    private final UserRepo userRepo;
    private PasswordEncoder passwordEncoder;


    public DbInit(ProductRepo productRepo, UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.productRepo = productRepo;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        Category testCat1 = new Category("cats");
        Category testCat2 = new Category("dogs");
        Category testCat3 = new Category("other");

        productRepo.saveAll(List.of(
                new Product("Piggy Bank", new BigDecimal(1.50), "https://m.media-amazon.com/images/I/51ckv2myWXL.jpg", List.of(testCat3)),
                new Product("Black cat", new BigDecimal(8.50), "https://www.rd.com/wp-content/uploads/2021/01/GettyImages-1175550351.jpg", List.of(testCat1)),
                new Product("Porky", new BigDecimal(8.50), "https://icdn.2cda.pl/g/122975_147752136690542103.jpg", List.of(testCat3)),
                new Product("Doberman", new BigDecimal(8.50), "https://s3.eu-central-1.amazonaws.com/cdn.psy.pl/dobek5_e1516890300644_95c91d49bf.jpg", List.of(testCat2)),
                new Product("Chomiuk", new BigDecimal(1.01), "https://i.wpimg.pl/1920x0/portal-abczdrowie.wpcdn.pl/imageCache/2019/03/07/64997855-m_47ea.jpg", List.of(testCat3)),
                new Product("Tutel", new BigDecimal(9.50), "https://assets.petco.com/petco/image/upload/f_auto,q_auto/aquatic-turtle-care-sheet-hero", List.of(testCat3)),
                new Product("Bear", new BigDecimal(9.50), "https://aletaniereczniki.pl/img/towary/1/2019_12/311-1.jpg", List.of(testCat3)),
                new Product("Dinoz", new BigDecimal(9.50), "https://a.allegroimg.com/s512/11d863/413cd9d141558f257500a4e43206/Lampka-nocna-dinozaur-Dinus-LED-DIPLODOK-niebieska", List.of(testCat3)),
                new Product("Rabbi", new BigDecimal(9.50), "https://cdn.drawception.com/images/panels/2018/1-1/rjzeBYSLjy-2.png", List.of(testCat3)),
                new Product("Juan", new BigDecimal(9.50), "https://i.imgflip.com/4ndpo6.png", List.of(testCat3))
        ));

        UserEntity user = new UserEntity();
        user.setUsername("admin");
        user.setEmail("admin");
        user.setPassword(passwordEncoder.encode("admin"));
        user.setRole(Role.ADMIN);

        UserEntity testUser = new UserEntity();
        testUser.setUsername("user1");
        testUser.setEmail("user1");
        testUser.setPassword(passwordEncoder.encode("user1"));
        testUser.setRole(Role.USER);

        UserEntity testUser2 = new UserEntity();
        testUser2.setUsername("user2");
        testUser2.setEmail("user2");
        testUser2.setPassword(passwordEncoder.encode("user2"));
        testUser2.setRole(Role.USER);

        userRepo.saveAll(List.of(
                user, testUser, testUser2
        ));

    }
}
