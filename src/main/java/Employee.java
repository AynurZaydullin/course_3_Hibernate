import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    private String gender;
    private int age;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;


    public Employee() {
    }
    public Employee(String first_name, String last_name, String gender, int age, City city) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public City getCity() {
        return city;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(City city) {
        this.city = city;
    }



    @Override
    public String toString() {
        return "Данные сотрудника c " +
                "id = " + id + ":" +
                " firstName = '" + first_name + '\'' +
                ", lastName = '" + last_name + '\'' +
                ", gender = '" + gender + '\'' +
                ", age = " + age +
                ", cityId = " + city
        ;
    }
}

//import java.util.Objects;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//@Entity
//@Table(name = "employee")
//public class Employee {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private long id;
//    @Column(name = "first_name")
//    private String first_name;
//    @Column(name = "last_name")
//    private String last_name;
//    @Column(name = "gender")
//    private String gender;
//    @Column(name = "age")
//    private int age;
//    @Column(name = "city_id")
//    private int city_id;
//
//
//    public Employee() {
//    }
//    public Employee(Long id, String first_name, String last_name, String gender, int age, int city_id) {
//        this.id = id;
//        this.first_name = first_name;
//        this.last_name = last_name;
//        this.gender = gender;
//        this.age = age;
//        this.city_id = city_id;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public String getFirstName() {
//        return first_name;
//    }
//
//    public String getLast_name() {
//        return last_name;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public int getCity_id() {
//        return city_id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public void setFirstName(String first_name) {
//        this.first_name = first_name;
//    }
//
//    public void setLast_name(String last_name) {
//        this.last_name = last_name;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public void setCity_id(int cityId) {
//        this.city_id = cityId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Employee employee = (Employee) o;
//        return id == employee.id && age == employee.age && city_id == employee.city_id && first_name.equals(employee.first_name) && last_name.equals(employee.last_name) && gender.equals(employee.gender);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, first_name, last_name, gender, age, city_id);
//    }
//
//    @Override
//    public String toString() {
//        return "Данные сотрудника c " +
//                "id = " + id + ":" +
//                " firstName = '" + first_name + '\'' +
//                ", lastName = '" + last_name + '\'' +
//                ", gender = '" + gender + '\'' +
//                ", age = " + age +
//                ", cityId = " + city_id
//                ;
//    }
//}