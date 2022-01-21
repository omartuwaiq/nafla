package com.example.eventms.model.Entities;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
public class Admins {

    @Id
    private String adminname;
    private String password;

    @OneToMany(mappedBy = "admins")
    @JsonIgnore
    private List<Events> items= new ArrayList<>();


    public Admins(String adminname, String password, List<Events> items) {
        this.adminname = adminname;
        this.password = password;
        this.items = items;
    }




    //

    public Admins() {
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Events> getItems() {
        return items;
    }

    public void setItems(List<Events> items) {
        this.items = items;
    }



    @Override
    public String toString() {
        return "Admins{" +
                "adminname='" + adminname + '\'' +
                ", password='" + password + '\'' +
//                ", items=" + items +
                '}';
    }
}

