package pl.sda.springecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.springecommerce.dto.RegistrationDto;
import pl.sda.springecommerce.model.Role;
import pl.sda.springecommerce.model.UserEntity;

import pl.sda.springecommerce.repository.UserRepo;

import java.util.Arrays;

@Service
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void saveUser(RegistrationDto registrationDto){
        UserEntity user = new UserEntity();
        user.setUsername(registrationDto.getUsername());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        user.setRole(Role.USER);
        userRepo.save(user);
    }

    public UserEntity findByEmail(String email){
        return userRepo.findByEmail(email);
    }

    public UserEntity findByUsername(String username){
        return userRepo.findByUsername(username);
    }


}
