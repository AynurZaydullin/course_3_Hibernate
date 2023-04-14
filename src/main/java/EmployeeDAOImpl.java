import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public void add(Employee employee) {
        // Создаем экземпляр EntityManager из EntityManagerFactory
        EntityManager entityManager = EntityConfig.createHibernateEntityManagerFactory().createEntityManager();
        // Начинаем транзакцию
        entityManager.getTransaction().begin();
        //Создание сущности
        entityManager.persist(employee);
        // Завершаем транзакцию
        entityManager.getTransaction().commit();
        entityManager.close();
        EntityConfig.createHibernateEntityManagerFactory().close();
    }

    @Override
    public Employee getEmployeeById(long id) {
        EntityManager entityManager = EntityConfig.createHibernateEntityManagerFactory().createEntityManager();
        //Нахождение сущности
        Employee employee =  entityManager.find(Employee.class, id);
        entityManager.close();
        EntityConfig.createHibernateEntityManagerFactory().close();
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        EntityManager entityManager = EntityConfig.createHibernateEntityManagerFactory().createEntityManager();
        // Создаю JPQL-запрос для выборки студентов
        String jpqlQuery = "SELECT employee FROM Employee employee";
        // Создаею объект запроса с указанием типа возвращаемого результата
        // (Student.class)
        TypedQuery<Employee> query = entityManager.createQuery(jpqlQuery, Employee.class);
        // Выполняею запрос и получаем результат в виде списка сотрудников
        List<Employee> employees = query.getResultList();
        entityManager.close();
        EntityConfig.createHibernateEntityManagerFactory().close();
        return employees;
    }

    @Override
    public void updateEmployee(Employee employee) {
        EntityManager entityManager = EntityConfig.createHibernateEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        //Изменяю существующую сущность
        entityManager.merge(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
        EntityConfig.createHibernateEntityManagerFactory().close();
    }

    @Override
    public void deleteEmployee(long id) {
        EntityManager entityManager = EntityConfig.createHibernateEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Employee employeeForRemoving = entityManager.find(Employee.class, id);
        //Удаляю существующую сущность
        entityManager.remove(employeeForRemoving);
        entityManager.getTransaction().commit();
        entityManager.close();
        EntityConfig.createHibernateEntityManagerFactory().close();
    }
}
