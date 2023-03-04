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
    private String brand;
    private String model;
    @Column(nullable = false, unique = true)
    private String license_plate;
    private String type;

    @ManyToMany(targetEntity = TeachersEntity.class ,fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<TeachersEntity> teachers = new ArrayList<>();

    public List<TeachersEntity> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TeachersEntity> teachers) {
        this.teachers = teachers;
        this.teachers.forEach(e -> e.getVehicles().add(this));
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void print(){
        String teacherName = "";
        for (TeachersEntity teacher : teachers) {
            teacherName += teacher.getName();
        }
        System.out.println("VehiclesEntity{" +
                "id=" + getId() +
                ", brand='" + getBrand() + '\'' +
                ", model=" + getModel() +
                ", type=" + getType() +
                ", license_plate=" + getLicense_plate() +
                ", owner=" + teacherName +
                '}');
    }
}
