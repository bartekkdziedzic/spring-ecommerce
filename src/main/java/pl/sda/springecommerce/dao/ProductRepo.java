package pl.sda.springecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.springecommerce.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
}
