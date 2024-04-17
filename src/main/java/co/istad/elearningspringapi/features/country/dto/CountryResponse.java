package co.istad.elearningspringapi.features.country.dto;

public record CountryResponse(
        String flag,
        String iso,
        String name,
        String niceName,
        Integer numCode,
        String phoneCode
) {
}
