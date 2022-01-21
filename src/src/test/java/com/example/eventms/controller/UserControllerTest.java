package com.example.eventms.controller;

import com.example.eventms.model.Entities.Admins;
import com.example.eventms.model.Entities.Events;
import com.example.eventms.model.Entities.Ticket;
import com.example.eventms.model.Entities.Users;
import com.example.eventms.model.Services.UserService;
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

class UserControllerTest {
    @Mock
    UserService userService;
    @InjectMocks
    UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetUsers() {
        when(userService.getUsers()).thenReturn(Arrays.<Users>asList(new Users("username", "password", Arrays.<Events>asList(new Events(0, "type", "eventName", "location", "time", "price", "duration", "src", new Admins("adminname", "password", Arrays.<Events>asList(null)), Arrays.<Users>asList(null), Arrays.<Ticket>asList(new Ticket(0, "name", null, null)))))));

        List<Users> result = userController.getUsers();
        Assertions.assertEquals(Arrays.<Users>asList(new Users("username", "password", Arrays.<Events>asList(new Events(0, "type", "eventName", "location", "time", "price", "duration", "src", new Admins("adminname", "password", Arrays.<Events>asList(null)), Arrays.<Users>asList(null), Arrays.<Ticket>asList(new Ticket(0, "name", null, null)))))), result);
    }

    @Test
    void testGetUser() {
        when(userService.getUser(anyString())).thenReturn(null);

        Optional<Users> result = userController.getUser("userId");
        Assertions.assertEquals(null, result);
    }

    @Test
    void testRegisterNewUser() {
        userController.registerNewUser(new Users("username", "password", Arrays.<Events>asList(new Events(0, "type", "eventName", "location", "time", "price", "duration", "src", new Admins("adminname", "password", Arrays.<Events>asList(null)), Arrays.<Users>asList(null), Arrays.<Ticket>asList(new Ticket(0, "name", null, null))))));
    }

    @Test
    void testDeleteUser() {
        userController.deleteUser("userId");
    }

    @Test
    void testCheckLogin() {
        when(userService.getCheck(anyString(), anyString())).thenReturn("getCheckResponse");

        String result = userController.checkLogin("username", "password");
        Assertions.assertEquals("getCheckResponse", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme