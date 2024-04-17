package co.istad.elearningspringapi.features.country;

import co.istad.elearningspringapi.domain.Country;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country,Long> {
    List<Country> findByNameContainingIgnoreCase(String name);
    Country findByIso(String iso);
}
