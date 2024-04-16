package co.istad.elearningspringapi.features.instructor.dto;

public record InstructorResponse(
        Long id,
        String biography,
        String github,
        Boolean isBlocked,
        String jobTitle,
        String linkedIn,
        Long userId,
        String website
) {
}

