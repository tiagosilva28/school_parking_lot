package spl.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // To create a Entity
public class VehiclesEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private int id;
    private String name;
    String type;


    @ManyToMany(targetEntity = TeachersEntity.class ,fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<TeachersEntity> teachers = new ArrayList<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }





    public void print(){
        String carsNames = "";
        for (TeachersEntity car : teachers) {
            carsNames += car.getName() + ", ";
        }
        System.out.println(carsNames);
    }
}
