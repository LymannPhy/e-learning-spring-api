package co.istad.elearningspringapi.features.student.dto;

public record StudentResponse(
        String username,
        String highSchool,
        String university,
        Boolean isBlocked
) {
}
