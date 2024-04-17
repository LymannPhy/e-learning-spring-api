package co.istad.elearningspringapi.features.country;

import co.istad.elearningspringapi.domain.Country;
import co.istad.elearningspringapi.features.city.dto.CityResponse;
import co.istad.elearningspringapi.features.country.dto.CountryResponse;
import co.istad.elearningspringapi.mapper.CountryMapper;
import org.springframework.data.domain.Sort;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService{
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;
    @Override
    public List<CountryResponse> getAllCountries(String filter, String sortBy) {
        List<Country> countries;
        if (filter != null && !filter.isEmpty()) {
            countries = countryRepository.findByNameContainingIgnoreCase(filter);
        } else {
            countries = countryRepository.findAll();
        }
        if (sortBy != null && sortBy.equals("name")) {
            countries.sort(Comparator.comparing(Country::getName));
        }
        return countries.stream()
                .map(countryMapper::toCountryResponse)
                .collect(Collectors.toList());
    }
}
