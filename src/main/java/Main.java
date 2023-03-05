import spl.entity.SpotsEntity;
import spl.entity.TeachersEntity;
import spl.entity.VehiclesEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("spl_details");
        EntityManager em = emf.createEntityManager();

        //Insert Teacher
        System.out.println("Insert new Teacher");
        em.getTransaction().begin();
        TeachersEntity t1 = new TeachersEntity("Christophe", 0);
        TeachersEntity t2 = new TeachersEntity("Diogo", 42);
        em.persist(t1);
        em.persist(t2);
        em.getTransaction().commit();
        System.out.println("-".repeat(50));

        //Get all the Teachers
        System.out.println("Print all Teachers");
        em.getTransaction().begin();
        em.createQuery("SELECT e FROM Teachers e", TeachersEntity.class)
                .getResultList()
                .forEach(TeachersEntity::print);
        em.getTransaction().commit();
        System.out.println("-".repeat(50));

        //Insert Vehicle
        System.out.println("Insert new Vehicles");
        em.getTransaction().begin();
        VehiclesEntity v1 = new VehiclesEntity();
        v1.setBrand("Toyota");
        v1.setModel("Celica");
        v1.setType("Car");
        v1.setLicense_plate("00-xx-00");
        v1.setTeachers(List.of(t1));
        VehiclesEntity v2 = new VehiclesEntity();
        v2.setBrand("Duccati");
        v2.setModel("Verona");
        v2.setType("Bike");
        v2.setLicense_plate("00-xx-01");
        v2.setTeachers(List.of(t2));
        em.persist(v1);
        em.persist(v2);
        em.getTransaction().commit();
        System.out.println("-".repeat(50));

        //Insert Spot
        System.out.println("Insert new Spots");
        em.getTransaction().begin();
        SpotsEntity s1 = new SpotsEntity();
        SpotsEntity s2 = new SpotsEntity();
        SpotsEntity s3 = new SpotsEntity();
        SpotsEntity s4 = new SpotsEntity();
        SpotsEntity s5 = new SpotsEntity();
        s1.setName("A1");
        s1.setVehicles(v1);
        s2.setName("A2");
        s3.setName("A3");
        s4.setName("A4");
        s5.setName("B1");
        em.persist(s1);
        em.persist(s2);
        em.persist(s3);
        em.persist(s4);
        em.persist(s5);
        em.getTransaction().commit();
        System.out.println("-".repeat(50));

        //Get all the Teachers again
        System.out.println("Print all Teachers ");
        em.getTransaction().begin();
        em.createQuery("SELECT e FROM Teachers e", TeachersEntity.class)
                .getResultList()
                .forEach(TeachersEntity::print);
        em.getTransaction().commit();
        System.out.println("-".repeat(50));

        //Get all the Vehicles
        System.out.println("Print all Vehicles ");
        em.getTransaction().begin();
        em.createQuery("SELECT e FROM Vehicles e", VehiclesEntity.class)
                .getResultList()
                .forEach(VehiclesEntity::print);
        em.getTransaction().commit();
        System.out.println("-".repeat(50));

        //Find the owner of a Vehicle
        System.out.println("Find the owner of a Vehicle");
        em.getTransaction().begin();
        VehiclesEntity vehicles = em.createQuery("SELECT e FROM Vehicles e WHERE e.id = :id", VehiclesEntity.class)
              .setParameter("id", 1)
              .setMaxResults(3)
              .getSingleResult();

        vehicles.getTeachers().forEach(TeachersEntity::print);
        em.getTransaction().commit();
        System.out.println("-".repeat(50));

        //Find a Vehicle in a spot
        System.out.println("Find a vehicle in a spot");
        em.getTransaction().begin();
        SpotsEntity spots = em.createQuery("SELECT e FROM Spots e WHERE e.id = :id", SpotsEntity.class)
                .setParameter("id", 1)
                .setMaxResults(3)
                .getSingleResult();

        spots.print();
        em.getTransaction().commit();
        System.out.println("-".repeat(50));

        //Find a Vehicle in a spot
        System.out.println("Find a vehicle in a spot");
        em.getTransaction().begin();
        spots = em.createQuery("SELECT e FROM Spots e WHERE e.id = :id", SpotsEntity.class)
                .setParameter("id", 2)
                .setMaxResults(3)
                .getSingleResult();

        spots.print();
        em.getTransaction().commit();
        System.out.println("-".repeat(50));

        emf.close();
        em.close();
    }
}