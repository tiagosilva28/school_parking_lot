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
        em.createQuery("SELECT e FROM TeachersEntity e", TeachersEntity.class)
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

        //Get all the Teachers again
        System.out.println("Print all Teachers ");
        em.getTransaction().begin();
        em.createQuery("SELECT e FROM TeachersEntity e", TeachersEntity.class)
                .getResultList()
                .forEach(TeachersEntity::print);
        em.getTransaction().commit();
        System.out.println("-".repeat(50));

        //Get all the Vehicles
        System.out.println("Print all Vehicles ");
        em.getTransaction().begin();
        em.createQuery("SELECT e FROM VehiclesEntity e", VehiclesEntity.class)
                .getResultList()
                .forEach(VehiclesEntity::print);
        em.getTransaction().commit();
        System.out.println("-".repeat(50));

        //Find the owner of a Vehicle
        System.out.println("Find the owner of a Vehicle");
        em.getTransaction().begin();
        VehiclesEntity vehicles = em.createQuery("SELECT e FROM VehiclesEntity e WHERE e.id = :id", VehiclesEntity.class)
              .setParameter("id", 4)
              .setMaxResults(3)
              .getSingleResult();

        vehicles.getTeachers().forEach(TeachersEntity::print);
        em.getTransaction().commit();
        System.out.println("-".repeat(50));



        emf.close();
        em.close();
    }
}