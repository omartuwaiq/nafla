package com.example.eventms.controller;

import com.example.eventms.model.Entities.Admins;
import com.example.eventms.model.Entities.Events;
import com.example.eventms.model.Entities.Ticket;
import com.example.eventms.model.Entities.Users;
import com.example.eventms.model.Services.TicketService;
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

class TicketControllerTest {
    @Mock
    TicketService ticketService;
    @InjectMocks
    TicketController ticketController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetTickets() {
        when(ticketService.getTickets()).thenReturn(Arrays.<Ticket>asList(new Ticket(0, "name", new Events(0, "type", "eventName", "location", "time", "price", "duration", "src", new Admins("adminname", "password", Arrays.<Events>asList(null)), Arrays.<Users>asList(new Users("username", "password", Arrays.<Events>asList(null))), Arrays.<Ticket>asList(null)), new Users("username", "password", Arrays.<Events>asList(new Events(0, "type", "eventName", "location", "time", "price", "duration", "src", new Admins("adminname", "password", Arrays.<Events>asList(null)), Arrays.<Users>asList(null), Arrays.<Ticket>asList(null)))))));

        List<Ticket> result = ticketController.getTickets();
        Assertions.assertEquals(Arrays.<Ticket>asList(new Ticket(0, "name", new Events(0, "type", "eventName", "location", "time", "price", "duration", "src", new Admins("adminname", "password", Arrays.<Events>asList(null)), Arrays.<Users>asList(new Users("username", "password", Arrays.<Events>asList(null))), Arrays.<Ticket>asList(null)), new Users("username", "password", Arrays.<Events>asList(new Events(0, "type", "eventName", "location", "time", "price", "duration", "src", new Admins("adminname", "password", Arrays.<Events>asList(null)), Arrays.<Users>asList(null), Arrays.<Ticket>asList(null)))))), result);
    }

    @Test
    void testGetTicket() {
        when(ticketService.getTicket(anyInt())).thenReturn(null);

        Optional<Ticket> result = ticketController.getTicket(Integer.valueOf(0));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testRegisterNewTicket() {
        ticketController.registerNewTicket(new Ticket(0, "name", new Events(0, "type", "eventName", "location", "time", "price", "duration", "src", new Admins("adminname", "password", Arrays.<Events>asList(null)), Arrays.<Users>asList(new Users("username", "password", Arrays.<Events>asList(null))), Arrays.<Ticket>asList(null)), new Users("username", "password", Arrays.<Events>asList(new Events(0, "type", "eventName", "location", "time", "price", "duration", "src", new Admins("adminname", "password", Arrays.<Events>asList(null)), Arrays.<Users>asList(null), Arrays.<Ticket>asList(null))))));
    }

    @Test
    void testDeleteTicket() {
        ticketController.deleteTicket(Integer.valueOf(0));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme