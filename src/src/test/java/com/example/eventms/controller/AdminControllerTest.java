package com.example.eventms.controller;

import com.example.eventms.model.Entities.Admins;
import com.example.eventms.model.Entities.Events;
import com.example.eventms.model.Entities.Ticket;
import com.example.eventms.model.Entities.Users;
import com.example.eventms.model.Services.AdminService;
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

class AdminControllerTest {
    @Mock
    AdminService adminService;
    @InjectMocks
    AdminController adminController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAdmins() {
        when(adminService.getAdmins()).thenReturn(Arrays.<Admins>asList(new Admins("adminname", "password", Arrays.<Events>asList(new Events(0, "type", "eventName", "location", "time", "price", "duration", "src", null, Arrays.<Users>asList(new Users("username", "password", Arrays.<Events>asList(null))), Arrays.<Ticket>asList(new Ticket(0, "name", null, new Users("username", "password", Arrays.<Events>asList(null)))))))));

        List<Admins> result = adminController.getAdmins();
        Assertions.assertEquals(Arrays.<Admins>asList(new Admins("adminname", "password", Arrays.<Events>asList(new Events(0, "type", "eventName", "location", "time", "price", "duration", "src", null, Arrays.<Users>asList(new Users("username", "password", Arrays.<Events>asList(null))), Arrays.<Ticket>asList(new Ticket(0, "name", null, new Users("username", "password", Arrays.<Events>asList(null)))))))), result);
    }

    @Test
    void testGetAdmin() {
        when(adminService.getAdmin(anyString())).thenReturn(null);

        Optional<Admins> result = adminController.getAdmin("adminId");
        Assertions.assertEquals(null, result);
    }

    @Test
    void testRegisterNewAdmin() {
        adminController.registerNewAdmin(new Admins("adminname", "password", Arrays.<Events>asList(new Events(0, "type", "eventName", "location", "time", "price", "duration", "src", null, Arrays.<Users>asList(new Users("username", "password", Arrays.<Events>asList(null))), Arrays.<Ticket>asList(new Ticket(0, "name", null, new Users("username", "password", Arrays.<Events>asList(null))))))));
    }

    @Test
    void testDeleteAdmin() {
        adminController.deleteAdmin("adminId");
    }

    @Test
    void testCheckLogin() {
        when(adminService.getCheck(anyString(), anyString())).thenReturn("getCheckResponse");

        String result = adminController.checkLogin("adminname", "password");
        Assertions.assertEquals("getCheckResponse", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme