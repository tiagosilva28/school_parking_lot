package spl.entity;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

public class TeachersEntity extends Person{

    private int age;

    @ManyToMany(mappedBy = "teachers", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER) // for many to many
    private List<CarsEntity> cars = new ArrayList<>();
    @ManyToMany(mappedBy = "teachers", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER) // for many to many
    private List<BikesEntity> bikes = new ArrayList<>();

    public TeachersEntity() {
        super();
    }

    public TeachersEntity(String name, int age) {
        super(name);
        this.age = age;
    }
}
