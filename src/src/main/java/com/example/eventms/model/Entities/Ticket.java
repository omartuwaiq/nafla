package com.example.eventms.model.Entities;

import javax.persistence.*;

@Entity
@Table
public class Ticket {
     @Id
    private int ticketId;
    private String name;


    //with event
    @ManyToOne
    @JoinColumn(name = "E_id" , referencedColumnName = "id")
    private Events events;
   //with user
  @ManyToOne
  @JoinColumn(name = "U_id" , referencedColumnName = "username")
  private Users users;


    public Ticket() {
    }



    public Ticket(int ticketId, String name, Events events, Users users) {
        this.ticketId = ticketId;
        this.name = name;
        this.events = events;
        this.users = users;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", name='" + name + '\'' +
                ", events=" + events +
                ", users=" + users +
                '}';
    }
}
