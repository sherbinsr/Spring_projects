package com.sherbin.onetomany.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Model {

    @Id
    private int model_id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "manufacture_id")
    private Manufactures ob;

    public Model(int model_id, String name, Manufactures ob) {
        this.model_id = model_id;
        this.name = name;
        this.ob = ob;
    }

    Model(){

    }

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manufactures getOb() {
        return ob;
    }

    public void setOb(Manufactures ob) {
        this.ob = ob;
    }
}
