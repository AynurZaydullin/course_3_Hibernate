import java.util.List;

public class Application {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        //Получаю список сотрудников
        List<Employee> employees = employeeDAO.getAllEmployees();
        // Вывожу информацию о сотрудниках в консоль
        for (Employee student : employees) {
            System.out.println("Employee ID: " + student.getId());
            System.out.println("Employee FirstName: " + student.getFirstName());
            System.out.println("Employee LastName: " + student.getLast_name());
            System.out.println("Employee gender: " + student.getGender());
            System.out.println("Employee Age: " + student.getAge());
            System.out.println("Employee city_id: " + student.getCity_id());
            System.out.println("------------");
        }

        EmployeeDAO employee = new EmployeeDAOImpl();
        Employee employee5 = new Employee((long)16, "AYNUR", "ZAYDULLIN", "m", 30, 4);
        employee.updateEmployee(employee5);
        System.out.println("Updated Employee ID: " + employee5.getId());
        System.out.println("Updated Employee LastName: " + employee5.getFirstName());
        System.out.println("Updated Employee gender: " + employee5.getGender());
        System.out.println("Updated Employee age: " + employee5.getAge());
        System.out.println("Updated Employee city_id: " + employee5.getCity_id());
        System.out.println();
        EmployeeDAO employee6 = new EmployeeDAOImpl();
        Employee employee7 = employee6.getEmployeeById(17);
        System.out.println(employee7);
        System.out.println();
        //Получаю обновленный список сотрудников
        employees = employeeDAO.getAllEmployees();
        // Вывожу информацию о сотрудниках в консоль
        for (Employee student : employees) {
            System.out.println("Employee ID: " + student.getId());
            System.out.println("Employee FirstName: " + student.getFirstName());
            System.out.println("Employee LastName: " + student.getLast_name());
            System.out.println("Employee gender: " + student.getGender());
            System.out.println("Employee Age: " + student.getAge());
            System.out.println("Employee city_id: " + student.getCity_id());
            System.out.println("------------");
        }
        employeeDAO.deleteEmployee(6);

        //Получаю обновленный список сотрудников
        employees = employeeDAO.getAllEmployees();
        // Вывожу информацию о сотрудниках в консоль
        for (Employee student : employees) {
            System.out.println("Employee ID: " + student.getId());
            System.out.println("Employee FirstName: " + student.getFirstName());
            System.out.println("Employee LastName: " + student.getLast_name());
            System.out.println("Employee gender: " + student.getGender());
            System.out.println("Employee Age: " + student.getAge());
            System.out.println("Employee city_id: " + student.getCity_id());
            System.out.println("------------");
        }
    }
}
