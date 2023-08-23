package pl.sda.springecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.springecommerce.dto.RegistrationDto;
import pl.sda.springecommerce.model.Role;
import pl.sda.springecommerce.model.UserEntity;
import pl.sda.springecommerce.repository.RoleRepo;
import pl.sda.springecommerce.repository.UserRepo;

import java.util.Arrays;

@Service
public class UserService {

    private UserRepo userRepo;
    private RoleRepo roleRepo;

    @Autowired
    public UserService(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    public void saveUser(RegistrationDto registrationDto){
        UserEntity user = new UserEntity();
        user.setId(registrationDto.getId());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        Role role = roleRepo.findByName("USER");
        user.setRoles(Arrays.asList(role));
        userRepo.save(user);
    }

    public UserEntity findByEmail(String email){
        return userRepo.findByEmail(email);
    }

    public UserEntity findByUsername(String username){
        return userRepo.findByUsername(username);
    }


}
