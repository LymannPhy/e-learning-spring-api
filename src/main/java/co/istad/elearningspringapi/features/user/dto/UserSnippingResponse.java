package co.istad.elearningspringapi.features.user.dto;

public record UserSnippingResponse(
        Long id,
        String uuid,
        String userName,
        String familyName,
        String givenName
) {
}
