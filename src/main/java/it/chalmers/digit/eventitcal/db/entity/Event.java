package it.chalmers.digit.eventitcal.db.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "event")
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "description")
    private String description;

    protected Event(){}

    public Event(String description){
        this.description = description;
    }

    @Override
    public String toString(){
        return description + " --- "+ id;
    }
}
