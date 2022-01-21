package com.example.eventms.model.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table
@Entity
public class Events {
    @Id
    private int id;
    private String type;
    private String eventName;
    private String location;
    private String time;
    private String price;
    private String duration;
    private String src;
//with admin
@ManyToOne
 @JoinColumn(name = "admin_id" , referencedColumnName = "adminname")
 private Admins admins;


//with user
    @ManyToMany (mappedBy = "events")
    @JsonIgnore
    private List<Users> users = new ArrayList<>();

//with ticket
  @OneToMany(mappedBy = "events")
  @JsonIgnore
  private List<Ticket> items2= new ArrayList<>();

    public Events() {
    }


    public Events(int id, String type, String eventName, String location, String time, String price, String duration, String src, Admins admins, List<Users> users, List<Ticket> items2) {
        this.id = id;
        this.type = type;
        this.eventName = eventName;
        this.location = location;
        this.time = time;
        this.price = price;
        this.duration = duration;
        this.src = src;
        this.admins = admins;
        this.users = users;
        this.items2 = items2;
    }


//


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    //

    public List<Ticket> getItems2() {
        return items2;
    }

    public void setItems2(List<Ticket> items2) {
        this.items2 = items2;
    }

    public Admins getAdmins() {
        return admins;
    }

    public void setAdmins(Admins admins) {
        this.admins = admins;
    }

    //

    @Override
    public String toString() {
        return "Events{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", eventName='" + eventName + '\'' +
                ", location='" + location + '\'' +
                ", time=" + time +
                ", price='" + price + '\'' +
                ", duration='" + duration + '\'' +
                ", src='" + src + '\'' +
                ", admins=" + admins +
                ", users=" + users +
                ", items2=" + items2 +
                '}';
    }
}