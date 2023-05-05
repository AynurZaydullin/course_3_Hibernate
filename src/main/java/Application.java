import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        //Создаю список сотрудников для добавления в базу данных
        List<Employee> newEmployees = new ArrayList<>();
        CityDAO cityDAO = new CityDAOImpl();
        //Создаю новый город.
        City city = new City("BIRSK", newEmployees);
        //Создаю сотрудника №1
        Employee employee1 = new Employee((long)21, "AYGUL", "ZAYDULLINA", "female", 29, city);
        //Создаю сотрудника №2
        Employee employee2 = new Employee((long)22, "GULFIYA", "MINNIBAEVA", "female", 26, city);
        //Создаю сотрудника №3
        Employee employee3 = new Employee((long)23, "RAVIL", "ZAYDULLIN", "male", 30, city);


        //Добавляю сотрудников в список
        newEmployees.add(employee1);
        newEmployees.add(employee2);
        newEmployees.add(employee3);
        //Добавляю город в базу данных
        cityDAO.add(city);
        //Вывожу информацию о городе в консоль
        city.toString();
        Employee employee4 = new Employee((long) 21, "NUR", "ZAYDULLIN", "male", 39, city);
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        employeeDAO.updateEmployee(employee4);
        cityDAO.deleteCity(5);
        //Получаю список городов
        List<City> cities = cityDAO.getAllCity();
        //Получаю список сотрудников
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

//        EmployeeDAO employee = new EmployeeDAOImpl();
//        Employee employee5 = new Employee((long)16, "AYNUR", "ZAYDULLIN", "m", 30, 4);
//        employee.updateEmployee(employee5);
//        System.out.println("Updated Employee ID: " + employee5.getId());
//        System.out.println("Updated Employee LastName: " + employee5.getFirstName());
//        System.out.println("Updated Employee gender: " + employee5.getGender());
//        System.out.println("Updated Employee age: " + employee5.getAge());
//        System.out.println("Updated Employee city_id: " + employee5.getCity_id());
//        System.out.println();
//        EmployeeDAO employee6 = new EmployeeDAOImpl();
//        Employee employee7 = employee6.getEmployeeById(17);
//        System.out.println(employee7);
//        System.out.println();
//        //Получаю обновленный список сотрудников
//        employees = employeeDAO.getAllEmployees();
//        // Вывожу информацию о сотрудниках в консоль
//        for (Employee student : employees) {
//            System.out.println("Employee ID: " + student.getId());
//            System.out.println("Employee FirstName: " + student.getFirstName());
//            System.out.println("Employee LastName: " + student.getLast_name());
//            System.out.println("Employee gender: " + student.getGender());
//            System.out.println("Employee Age: " + student.getAge());
//            System.out.println("Employee city_id: " + student.getCity_id());
//            System.out.println("------------");
//        }
//        employeeDAO.deleteEmployee(6);
//
//        //Получаю обновленный список сотрудников
//        employees = employeeDAO.getAllEmployees();
//        // Вывожу информацию о сотрудниках в консоль
//        for (Employee student : employees) {
//            System.out.println("Employee ID: " + student.getId());
//            System.out.println("Employee FirstName: " + student.getFirstName());
//            System.out.println("Employee LastName: " + student.getLast_name());
//            System.out.println("Employee gender: " + student.getGender());
//            System.out.println("Employee Age: " + student.getAge());
//            System.out.println("Employee city_id: " + student.getCity_id());
//            System.out.println("------------");
//        }
    }
}
