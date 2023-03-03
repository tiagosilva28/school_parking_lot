package spl.entity;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

public class CarsEntity extends Vehicle{

    @ManyToMany(targetEntity = TeachersEntity.class ,fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<TeachersEntity> teachers = new ArrayList<>();
}
