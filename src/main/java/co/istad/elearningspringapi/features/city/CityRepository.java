package co.istad.elearningspringapi.features.city;

import co.istad.elearningspringapi.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findAll();
    List<City> findByNameContainingIgnoreCase(String name);
    List<City> findByCountryIso(String iso);
}
