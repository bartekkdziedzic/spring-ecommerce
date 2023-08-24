package pl.sda.springecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.springecommerce.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
