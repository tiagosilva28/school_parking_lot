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



        em.getTransaction().commit();
    }
}