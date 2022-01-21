package com.example.eventms.controller;

import com.example.eventms.model.Entities.Admins;
import com.example.eventms.model.Entities.Events;
import com.example.eventms.model.Entities.Ticket;
import com.example.eventms.model.Entities.Users;
import com.example.eventms.model.Services.EventService;
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

class EventControllerTest {
    @Mock
    EventService eventService;
    @InjectMocks
    EventController eventController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetEvents() {
        when(eventService.getEvents()).thenReturn(Arrays.<Events>asList(new Events(0, "type", "eventName", "location", "time", "price", "duration", "src", new Admins("adminname", "password", Arrays.<Events>asList(null)), Arrays.<Users>asList(new Users("username", "password", Arrays.<Events>asList(null))), Arrays.<Ticket>asList(new Ticket(0, "name", null, new Users("username", "password", Arrays.<Events>asList(null)))))));

        List<Events> result = eventController.getEvents();
        Assertions.assertEquals(Arrays.<Events>asList(new Events(0, "type", "eventName", "location", "time", "price", "duration", "src", new Admins("adminname", "password", Arrays.<Events>asList(null)), Arrays.<Users>asList(new Users("username", "password", Arrays.<Events>asList(null))), Arrays.<Ticket>asList(new Ticket(0, "name", null, new Users("username", "password", Arrays.<Events>asList(null)))))), result);
    }

    @Test
    void testGetEvent() {
        when(eventService.getEvent(anyInt())).thenReturn(null);

        Optional<Events> result = eventController.getEvent(Integer.valueOf(0));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testRegisterNewEvent() {
        eventController.registerNewEvent(new Events(0, "type", "eventName", "location", "time", "price", "duration", "src", new Admins("adminname", "password", Arrays.<Events>asList(null)), Arrays.<Users>asList(new Users("username", "password", Arrays.<Events>asList(null))), Arrays.<Ticket>asList(new Ticket(0, "name", null, new Users("username", "password", Arrays.<Events>asList(null))))));
    }

    @Test
    void testDeleteEvent() {
        eventController.deleteEvent("eventId");
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme