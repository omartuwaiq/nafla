package com.example.eventms.model.Services;


import com.example.eventms.model.Entities.Users;
import com.example.eventms.model.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {





    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    public Optional<Users> getUser(String userId) {
        return userRepository.findById(userId);

    }

    public void addNewUser(Users user) {
        userRepository.save(user);

    }


    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public String getCheck(String username ,String password) {
        if( userRepository.existsById(username)  ) {

            String Users = userRepository.findByUsername(username);
            if (Users.equals(password)) {
                return "welcome you Authentication User";
            } else {
                return " sorry not  Authentication";
            }
        }
        return "sorry not  Authentication";
    }





}
