import spl.entity.TeachersEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("spl_details");
        EntityManager em = emf.createEntityManager();

        //Insert Employee
        System.out.println("Insert new Employees");
        em.getTransaction().begin();

        TeachersEntity e1 = new TeachersEntity("Christophe", 0);
        TeachersEntity e2 = new TeachersEntity("Diogo", 42);

        em.persist(e1);
        em.persist(e2);

        em.getTransaction().commit();

        // Get all the Employees
        System.out.println("Print all the Employees");
        em.getTransaction().begin();

        em.createQuery("SELECT e FROM TeachersEntity e", TeachersEntity.class)
                .getResultList()
                .forEach(TeachersEntity::print);

        em.getTransaction().commit();

        emf.close();
        em.close();
    }
}