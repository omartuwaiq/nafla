package com.example.eventms.model.Services;

import com.example.eventms.model.Entities.Events;
import com.example.eventms.model.Repository.EventRepository;
import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EventService {

      private EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Events> getEvents() {
        return eventRepository.findAll();
    }

    public Optional<Events> getEvent(Integer eventId) {
        return eventRepository.findById(eventId);

    }
//    public void addNewEvent(Events event){
//        eventRepository.save(event);
//    }
public void addNewEvent(Events event) {
    eventRepository.save(event);

}


    public void deleteEvent(Integer eventId) {
        eventRepository.deleteById(eventId);
        //boolean exist = studentRepository.existsById(studentId);
        // put a condition on 'exist'. if exist then delete
    }
    }




