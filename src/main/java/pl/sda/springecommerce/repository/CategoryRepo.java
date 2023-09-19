package pl.sda.springecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.springecommerce.model.Category;

public interface CategoryRepo extends JpaRepository <Category, Long> {
}
