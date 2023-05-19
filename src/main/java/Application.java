import org.hibernate.NonUniqueResultException;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        //Создаю список сотрудников для добавления в базу данных
        List<Employee> newEmployees = new ArrayList<>();
        //Создаю новый город.
        City city = new City("BIRSK",newEmployees);
        //Создаю сотрудника №1
        Employee employee1 = new Employee( "AYGUL", "ZAYDULLINA", "female", 29, city);
        //Создаю сотрудника №2
        Employee employee2 = new Employee( "GULFIYA", "MINNIBAEVA", "female", 26, city);
        //Создаю сотрудника №3
        Employee employee3 = new Employee("RAVIL", "ZAYDULLIN", "male", 50, city);

        //Добавляю сотрудников в список
        newEmployees.add(employee1);
        newEmployees.add(employee2);
        newEmployees.add(employee3);
        //Добавляю город в базу данных
        CityDAO cityDAO = new CityDAOImpl();
        cityDAO.add(city);
        //Вывожу информацию о городе в консоль
        System.out.println(city.toString());

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        List<Employee> employees = employeeDAO.getAllEmployees();
        // Вывожу информацию о сотрудниках в консоль
        for (Employee employee : employees) {
            System.out.println("Employee ID: " + employee.getId());
            System.out.println("Employee FirstName: " + employee.getFirstName());
            System.out.println("Employee LastName: " + employee.getLast_name());
            System.out.println("Employee gender: " + employee.getGender());
            System.out.println("Employee Age: " + employee.getAge());
            System.out.println("Employee city: " + employee.getCity());
            System.out.println("------------");
        }

        //Изменяю данные сотрудника employee3
        employee3.setFirstName("NUR");
        employee3.setAge(51);
        employeeDAO.updateEmployee(employee3);        //Обновляю данные нового работника employee3.
        System.out.println();
        System.out.println();
        employees = employeeDAO.getAllEmployees();
        // Вывожу информацию о сотрудниках в консоль после изменения данных сотрудника employee3
        for (Employee employee : employees) {
            System.out.println("Employee ID: " + employee.getId());
            System.out.println("Employee FirstName: " + employee.getFirstName());
            System.out.println("Employee LastName: " + employee.getLast_name());
            System.out.println("Employee gender: " + employee.getGender());
            System.out.println("Employee Age: " + employee.getAge());
            System.out.println("Employee city: " + employee.getCity());
            System.out.println("------------");
        }

        System.out.println();
        System.out.println("Список городов до удаления города 'BIRSK':");
        //Получаю список городов
        List<City> cities = cityDAO.getAllCity();
        for (City city1 : cities) {
            System.out.println("City id:" + city1.getCity_id());
            System.out.println();
            System.out.println("City name:" + city1.getCityName());
            System.out.println();
        }
        cityDAO.deleteCity(city.getCity_id());
        cities = cityDAO.getAllCity();
        System.out.println();
        System.out.println("Список городов после удаления города 'BIRSK':");
        for (City city1 : cities) {
            System.out.println("City id:" + city1.getCity_id());
            System.out.println();
            System.out.println("City name:" + city1.getCityName());
            System.out.println();
        }

        System.out.println();
        System.out.println();
        employees = employeeDAO.getAllEmployees();
        // Вывожу информацию о сотрудниках в консоль после удаления города 'BIRSK'
        for (Employee employee : employees) {
            System.out.println("Employee ID: " + employee.getId());
            System.out.println("Employee FirstName: " + employee.getFirstName());
            System.out.println("Employee LastName: " + employee.getLast_name());
            System.out.println("Employee gender: " + employee.getGender());
            System.out.println("Employee Age: " + employee.getAge());
            System.out.println("Employee city: " + employee.getCity());
            System.out.println("------------");
        }
    }
}
