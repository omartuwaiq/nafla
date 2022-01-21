package com.example.eventms.controller;


import com.example.eventms.model.Entities.Users;
import com.example.eventms.model.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path ="api/users")
public class UserController {



        private UserService userService ;

        @Autowired
        public UserController(UserService userService) {
            this.userService = userService;
        }

        @GetMapping
        public List<Users> getUsers() {
            return userService.getUsers();
        }

        @GetMapping(path = "{userId}")
        public Optional<Users> getUser(@PathVariable(name = "userId") String userId) {
            return userService.getUser(userId);
        }

        @PostMapping(path= "add")
        public void registerNewUser(@RequestBody Users user){
            userService.addNewUser(user);
        }

        @DeleteMapping(path = "delete/{userId}")
        public void deleteUser(@PathVariable ("userId") String userId){
            userService.deleteUser(userId);
        }


        @GetMapping(path = "login")
        public String checkLogin(@RequestParam (name = "username") String username , @RequestParam (name = "password")
                String password ) {
            return userService.getCheck(username,password);

        }

}
