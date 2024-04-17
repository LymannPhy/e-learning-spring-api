package co.istad.elearningspringapi.mapper;

import co.istad.elearningspringapi.domain.Country;
import co.istad.elearningspringapi.features.country.dto.CountryResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryResponse toCountryResponse(Country country);
}
