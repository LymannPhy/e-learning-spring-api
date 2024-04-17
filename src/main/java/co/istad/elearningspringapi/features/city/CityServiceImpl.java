package co.istad.elearningspringapi.features.city;

import co.istad.elearningspringapi.domain.City;
import co.istad.elearningspringapi.features.city.dto.CityResponse;
import co.istad.elearningspringapi.mapper.CityMapper;
import java.util.Comparator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CityServiceImpl implements CityService{
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;
    @Override
    public List<CityResponse> getAllCities(String filter, String sortBy) {
        List<City> cities;
        if (filter != null && !filter.isEmpty()) {
            cities = cityRepository.findByNameContainingIgnoreCase(filter);
        } else {
            cities = cityRepository.findAll();
        }
        if (sortBy != null && sortBy.equals("name")) {
            cities.sort(Comparator.comparing(City::getName));
        }
        return cityMapper.toCityResponseList(cities);
    }

    @Override
    public List<CityResponse> getAllCitiesInCountry(String iso) {
        List<City> cities = cityRepository.findByCountryIso(iso);
        return cities.stream()
                .map(cityMapper::toCityResponse)
                .collect(Collectors.toList());
    }
}
