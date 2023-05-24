import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int city_id;
    private String city_name;

    //Связываю сущности город (city) и сотрудников (employees) связью: "OneToMany".
    //Также включаю полную каскадность: "CascadeType.ALL". Это означает, что при создании нового города
    // обновлении город, добавления сотрудников, сохранении, а также удалении города,
    // то будет обнослен не только город, но и сотрудники.
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //FetchType.LAZY - можно не указывать. Этот тип стоит по умолчанию.
    private List<Employee> employees;

    public City( String city_name, List<Employee> employees) {
        this.city_name = city_name;
        this.employees = employees;
    }

    public City() {}

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCityName() {
        return city_name;
    }

    public void setCityName(String city_name) {
        this.city_name = city_name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Информация о городе: " +
                "id=" + city_id +
                ", Название = " + city_name +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return city_id == city.city_id && Objects.equals(city_name, city.city_name) && Objects.equals(employees, city.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city_id, city_name, employees);
    }
}
