package spl.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity(name = "Spots")
public class SpotsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private String name;

    @OneToOne(targetEntity = VehiclesEntity.class)
    private VehiclesEntity vehicles;

    public VehiclesEntity getVehicles() {
        return vehicles;
    }
    public void setVehicles(VehiclesEntity vehicles) {
        this.vehicles = vehicles;
    }
    public void setVehicle(VehiclesEntity vehicle){
        this.vehicles = vehicle;
    }
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
        String vLicense_plate = null;
        if(vehicles != null){
            vLicense_plate = "" + vehicles.getLicense_plate();
        }

        System.out.println("SpotsEntity{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", license_plate=" + vLicense_plate +
                '}');
    }
}
