import java.util.List;

public interface CityDAO {
    void add(City city);

    City getById(int id);

    List<City> getAllCity();

    void updateCity(City city);

    void deleteCity(int id);

}
