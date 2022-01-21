package com.example.eventms.controller;

import com.example.eventms.model.Entities.Events;
import com.example.eventms.model.Services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping(path ="api/event")
public class EventController{

    private EventService eventService ;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Events> getEvents() {
        return eventService.getEvents();
    }

    @GetMapping(path = "{eventId}")
    public Optional<Events> getEvent(@PathVariable(name = "eventId") Integer eventId) {
        return eventService.getEvent(eventId);
    }
//    @PostMapping("add")
//    public void registerNewEvent(@RequestBody Events event){
//        eventService.addNewEvent(event);
//    }
@PostMapping(path= "add")
public void registerNewEvent(@RequestBody Events event){
    eventService.addNewEvent(event);
}
//
//    @DeleteMapping(path = "delete/{eventId}")
//    public void deleteEvent(@PathVariable ("eventId") Integer eventId){
//        eventService.deleteEvent(eventId);
//    }
    @DeleteMapping(path = "delete/{eventId}")
    public void deleteEvent(@PathVariable ("eventId") String eventId){
        int evenInt =Integer.parseInt(eventId);
        eventService.deleteEvent(evenInt);
    }
}




