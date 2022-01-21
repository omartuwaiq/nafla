package com.example.eventms.model.Services;

import com.example.eventms.model.Entities.Admins;
import com.example.eventms.model.Entities.Events;
import com.example.eventms.model.Entities.Ticket;
import com.example.eventms.model.Entities.Users;
import com.example.eventms.model.Repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class UserServiceTest {
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetUsers() {
        List<Users> result = userService.getUsers();
        Assertions.assertEquals(Arrays.<Users>asList(new Users("username", "password", Arrays.<Events>asList(new Events(0, "type", "eventName", "location", "time", "price", "duration", "src", new Admins("adminname", "password", Arrays.<Events>asList(null)), Arrays.<Users>asList(null), Arrays.<Ticket>asList(new Ticket(0, "name", null, null)))))), result);
    }

    @Test
    void testGetUser() {
        Optional<Users> result = userService.getUser("userId");
        Assertions.assertEquals(Optional.empty(), result);
    }

    @Test
    void testAddNewUser() {
        userService.addNewUser(new Users("username", "password", Arrays.<Events>asList(new Events(0, "type", "eventName", "location", "time", "price", "duration", "src", new Admins("adminname", "password", Arrays.<Events>asList(null)), Arrays.<Users>asList(null), Arrays.<Ticket>asList(new Ticket(0, "name", null, null))))));
    }

    @Test
    void testDeleteUser() {
        userService.deleteUser("userId");
    }

    @Test
    void testGetCheck() {
        when(userRepository.findByUsername(anyString())).thenReturn("findByUsernameResponse");

        String result = userService.getCheck("username", "password");
        Assertions.assertEquals("sorry not  Authentication", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme