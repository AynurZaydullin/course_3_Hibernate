import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CityDAOImpl implements CityDAO{
    @Override
    public void add(City city) {
        // Создаем экземпляр EntityManager из EntityManagerFactory
        EntityManager entityManager = EntityConfig.createHibernateEntityManagerFactory().createEntityManager();
        // Начинаем транзакцию
        entityManager.getTransaction().begin();
        //Создание сущности
        entityManager.persist(city);
        // Завершаем транзакцию
        entityManager.getTransaction().commit();
        entityManager.close();
        EntityConfig.createHibernateEntityManagerFactory().close();
    }

    @Override
    public City getById(int id) {
        EntityManager entityManager = EntityConfig.createHibernateEntityManagerFactory().createEntityManager();
        //Нахождение сущности
        City city =  entityManager.find(City.class, id);
        entityManager.close();
        EntityConfig.createHibernateEntityManagerFactory().close();
        return city;
    }

    @Override
    public List<City> getAllCity() {        EntityManager entityManager = EntityConfig.createHibernateEntityManagerFactory().createEntityManager();
        // Создаю JPQL-запрос для выборки студентов
        String jpqlQuery = "SELECT city FROM City city";
        // Создаею объект запроса с указанием типа возвращаемого результата
        // (Student.class)
        TypedQuery<City> query = entityManager.createQuery(jpqlQuery, City.class);
        // Выполняею запрос и получаем результат в виде списка сотрудников
        List<City> cities = query.getResultList();
        entityManager.close();
        EntityConfig.createHibernateEntityManagerFactory().close();
        return cities;
    }

    @Override
    public void updateCity(City city) {
        EntityManager entityManager = EntityConfig.createHibernateEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        //Изменяю существующую сущность
        entityManager.merge(city);
        entityManager.getTransaction().commit();
        entityManager.close();
        EntityConfig.createHibernateEntityManagerFactory().close();
    }

    @Override
    public void deleteCity(int id) {
        EntityManager entityManager = EntityConfig.createHibernateEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        City cityForRemoving = entityManager.find(City.class, id);
        //Удаляю существующую сущность
        entityManager.remove(cityForRemoving);
        entityManager.getTransaction().commit();
        entityManager.close();
        EntityConfig.createHibernateEntityManagerFactory().close();
    }
}
