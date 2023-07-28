package com.sherbin.onetomany.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Manufactures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // One manufactures can produces
    // multiple models of the bike
    private  String manufactures_name;

    @OneToMany(mappedBy ="ob")

    private List<Model> models;

    public Manufactures(int id, String manufactures_name) {
        this.id = id;
        this.manufactures_name = manufactures_name;
    }

    Manufactures(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufactures_name() {
        return manufactures_name;
    }

    public void setManufactures_name(String manufactures_name) {
        this.manufactures_name = manufactures_name;
    }
}
