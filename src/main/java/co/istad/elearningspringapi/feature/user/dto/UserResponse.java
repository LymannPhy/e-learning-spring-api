package co.istad.elearningspringapi.feature.user.dto;

public record UserResponse(
        Long id,
        String username,
        String email,
        String givenName,
        String familyName,
        String phoneNumber
) {
}
