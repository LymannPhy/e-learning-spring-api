package co.istad.elearningspringapi.features.user.dto;

public record UserResponse(
        Long id,
        String username,
        String email,
        String givenName,
        String familyName,
        String phoneNumber
) {
}