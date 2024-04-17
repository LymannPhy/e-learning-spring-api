package co.istad.elearningspringapi.features.city;

import co.istad.elearningspringapi.features.city.dto.CityResponse;

import java.util.List;

public interface CityService {
    List<CityResponse> getAllCities(String filter, String sortBy);
    List<CityResponse> getAllCitiesInCountry(String iso);
}
