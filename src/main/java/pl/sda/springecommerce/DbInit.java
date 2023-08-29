package pl.sda.springecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.sda.springecommerce.model.Role;
import pl.sda.springecommerce.model.UserEntity;
import pl.sda.springecommerce.repository.ProductRepo;
import pl.sda.springecommerce.model.Product;

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
        productRepo.saveAll(List.of(
                new Product("Piggy Bank", new BigDecimal(7.50), "https://m.media-amazon.com/images/I/51ckv2myWXL.jpg"),
                new Product("Black cat", new BigDecimal(8.50), "https://www.rd.com/wp-content/uploads/2021/01/GettyImages-1175550351.jpg"),
                new Product("Porky", new BigDecimal(9.50), "https://icdn.2cda.pl/g/122975_147752136690542103.jpg")
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
       user,testUser,testUser2
     //   new UserEntity(2L,"user1","user1","user1",Role.USER)
));


    }
}
