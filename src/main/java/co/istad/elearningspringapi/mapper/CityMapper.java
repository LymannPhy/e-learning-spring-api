package co.istad.elearningspringapi.mapper;

import co.istad.elearningspringapi.domain.City;
import co.istad.elearningspringapi.features.city.dto.CityResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {
    @Mapping(source = "country.iso", target = "countryIso")
    CityResponse toCityResponse(City city);

    List<CityResponse> toCityResponseList(List<City> cities);
}
