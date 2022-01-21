package com.example.eventms.model.Services;

import com.example.eventms.model.Entities.Admins;
import com.example.eventms.model.Entities.Events;
import com.example.eventms.model.Entities.Ticket;
import com.example.eventms.model.Entities.Users;
import com.example.eventms.model.Repository.AdminRepository;
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

class AdminServiceTest {
    @Mock
    AdminRepository adminRepository;
    @InjectMocks
    AdminService adminService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAdmins() {
        List<Admins> result = adminService.getAdmins();
        Assertions.assertEquals(Arrays.<Admins>asList(new Admins("adminname", "password", Arrays.<Events>asList(new Events(0, "type", "eventName", "location", "time", "price", "duration", "src", null, Arrays.<Users>asList(new Users("username", "password", Arrays.<Events>asList(null))), Arrays.<Ticket>asList(new Ticket(0, "name", null, new Users("username", "password", Arrays.<Events>asList(null)))))))), result);
    }

    @Test
    void testGetAdmin() {
        Optional<Admins> result = adminService.getAdmin("adminId");
        Assertions.assertEquals(Optional.empty(), result);
    }

    @Test
    void testAddNewAdmin() {
        adminService.addNewAdmin(new Admins("adminname", "password", Arrays.<Events>asList(new Events(0, "type", "eventName", "location", "time", "price", "duration", "src", null, Arrays.<Users>asList(new Users("username", "password", Arrays.<Events>asList(null))), Arrays.<Ticket>asList(new Ticket(0, "name", null, new Users("username", "password", Arrays.<Events>asList(null))))))));
    }

    @Test
    void testDeleteAdmin() {
        adminService.deleteAdmin("adminId");
    }

    @Test
    void testGetCheck() {
        when(adminRepository.findByUsername(anyString())).thenReturn("findByUsernameResponse");

        String result = adminService.getCheck("adminname", "password");
        Assertions.assertEquals("sorry not  Authentication ", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme