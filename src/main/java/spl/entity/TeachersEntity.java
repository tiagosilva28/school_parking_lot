package spl.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // To create a Entity
public class TeachersEntity extends Person{

    private int age;

    @ManyToMany(mappedBy = "teachers", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER) // for many to many
    private List<VehiclesEntity> vehicles = new ArrayList<>();

    public TeachersEntity() {
        super();
    }

    public TeachersEntity(String name, int age) {
        super(name);
        this.age = age;
    }

    public List<VehiclesEntity> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehiclesEntity> vehicles) {
        this.vehicles = vehicles;
        this.vehicles.forEach(c -> c.getTeachers().add(this));
    }

    public void setVehicle(VehiclesEntity vehicle) {
        this.vehicles.add(vehicle);
        vehicle.getTeachers().add(this);
    }

    public void print() {
        String vehicleName = "[";
        for (VehiclesEntity vehicle : vehicles) {
            vehicleName += vehicle.getType() + ": ";
            vehicleName += vehicle.getBrand() + " ";
            vehicleName += vehicle.getModel() + ", ";
            vehicleName += vehicle.getLicense_plate() + "]";
        }

        System.out.println("TeachersEntity{" +
                "id=" + getPersonId() +
                ", name='" + getName() + '\'' +
                ", age=" + age +
                ", vehicles=" + vehicleName +
                '}');
    }
}
