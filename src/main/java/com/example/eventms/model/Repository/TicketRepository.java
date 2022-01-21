package com.example.eventms.model.Repository;

import com.example.eventms.model.Entities.Events;
import com.example.eventms.model.Entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {

}
