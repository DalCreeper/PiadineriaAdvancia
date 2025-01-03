import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaTest {
    public static void main(String[] args) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence.xml");
            EntityManager em = emf.createEntityManager();
            em.close();
            emf.close();
            System.out.println("JPA Test succeeded.");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}