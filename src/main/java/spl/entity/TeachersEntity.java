package spl.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // To create a Entity
public class TeachersEntity extends Person{

    private int age;

    @ManyToMany(mappedBy = "teachers", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER) // for many to many
    private List<VehiclesEntity> cars = new ArrayList<>();

    /*
    @ManyToMany(mappedBy = "teachers", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER) // for many to many
    private List<BikesEntity> bikes = new ArrayList<>();
    */

    public TeachersEntity() {
        super();
    }

    public TeachersEntity(String name, int age) {
        super(name);
        this.age = age;
    }

    public List<VehiclesEntity> getcars() {
        return cars;
    }

    public void print() {

        System.out.println("TeachersEntity{" +
                "id=" + getPersonId() +
                ", name='" + getName() + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                ", bikes=" +
                '}');
    }
}
