package com.example.eventms.controller;

import com.example.eventms.model.Entities.Ticket;
import com.example.eventms.model.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(path ="api/ticket")
public class TicketController {
       private TicketService ticketService ;

        @Autowired
        public TicketController(TicketService ticketService) {
            this.ticketService = ticketService;
        }

        @GetMapping
        public List<Ticket> getTickets() {
            return ticketService.getTickets();
        }

        @GetMapping(path = "{ticketId}")
        public Optional<Ticket> getTicket(@PathVariable(name = "ticketId") Integer ticketId) {
            return ticketService.getTicket(ticketId);
        }

        @PostMapping(path= "add")
        public void registerNewTicket(@RequestBody Ticket ticket){
            ticketService.addNewTicket(ticket);
        }

    @DeleteMapping(path = "delete/{ticketId}")
    public void deleteTicket(@PathVariable ("ticketId") Integer ticketId){
        ticketService.deleteTicket(ticketId);
    }

}



