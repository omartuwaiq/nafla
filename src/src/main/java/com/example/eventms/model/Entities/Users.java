package com.example.eventms.model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table

public class Users {

    @Id
    @Column(updatable = false)
    private String username;
    @Column(updatable = false, nullable = false)
    private String password;
    //with event
    @ManyToMany
    @JoinTable(name = "USER_EVENT",
            joinColumns = @JoinColumn(name = "user_name"),
            inverseJoinColumns = @JoinColumn(name = "Event_id"))
            private List<Events> events = new ArrayList<>();

    //with ticket
  @OneToMany(mappedBy = "users")
  @JsonIgnore
  private List<Ticket> items3= new ArrayList<>();

    public Users(String username, String password, List<Events> events) {
        this.username = username;
        this.password = password;
        this.events = events;
    }

    public List<Events> getEvents() {
        return events;
    }

    public void setEvents(List<Events> events) {
        this.events = events;
    }

    public Users() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Ticket> getItems3() {
        return items3;
    }

    public void setItems3(List<Ticket> items3) {
        this.items3 = items3;
    }

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
