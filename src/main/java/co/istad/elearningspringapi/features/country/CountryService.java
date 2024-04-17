package co.istad.elearningspringapi.features.country;
import co.istad.elearningspringapi.features.country.dto.CountryResponse;

import java.util.List;

public interface CountryService {
    List<CountryResponse> getAllCountries(String filter, String sortBy);
}
