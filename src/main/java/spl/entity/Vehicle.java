package spl.entity;

import javax.persistence.*;

@MappedSuperclass
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private int id;
    private String name;

    // constructor, getters, setters


    public Vehicle() {
    }

    public Vehicle(int personId, String name) {
        this.id = personId;
        this.name = name;
    }

    public Vehicle(String name) {
        this.name = name;
    }

    public int getPersonId() {
        return id;
    }

    public void setPersonId(int personId) {
        this.id = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}