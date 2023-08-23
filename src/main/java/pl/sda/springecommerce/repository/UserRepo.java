package pl.sda.springecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.springecommerce.model.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);

}
