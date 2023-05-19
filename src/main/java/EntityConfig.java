import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityConfig {
    private static EntityManagerFactory entityManagerFactory;
    public static EntityManagerFactory createHibernateEntityManagerFactory() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        return entityManagerFactory;
    }
}