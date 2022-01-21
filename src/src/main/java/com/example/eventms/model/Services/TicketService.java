package com.example.eventms.model.Services;

import com.example.eventms.model.Entities.Ticket;
import com.example.eventms.model.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TicketService {


    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> getTicket(Integer ticketId) {
        return ticketRepository.findById(ticketId);

    }

    public void addNewTicket(Ticket ticket) {
        ticketRepository.save(ticket);

    }


    public void deleteTicket(Integer ticketId) {
        ticketRepository.deleteById(ticketId);

    }
}
