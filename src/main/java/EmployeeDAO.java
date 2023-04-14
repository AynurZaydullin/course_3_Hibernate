import java.util.List;

public interface EmployeeDAO{
    List<Employee> getAllEmployees();
//
    Employee getEmployeeById(long id);
//
    void add(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(long id);
}
