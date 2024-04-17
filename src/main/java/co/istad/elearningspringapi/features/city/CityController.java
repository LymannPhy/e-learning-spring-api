package co.istad.elearningspringapi.features.city;

import co.istad.elearningspringapi.features.city.dto.CityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @GetMapping("/api/v1/cities")
    public List<CityResponse> getAllCities(
            @RequestParam(required = false) String filter,
            @RequestParam(required = false) String sortBy) {
        return cityService.getAllCities(filter, sortBy);
    }
    @GetMapping("/api/v1/countries/{iso}/cities")
    public List<CityResponse> getAllCitiesInCountry(@PathVariable String iso) {
        return cityService.getAllCitiesInCountry(iso);
    }
}
