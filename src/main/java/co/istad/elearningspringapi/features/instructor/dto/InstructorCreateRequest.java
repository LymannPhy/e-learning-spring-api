package co.istad.elearningspringapi.features.instructor.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InstructorCreateRequest(
        @NotBlank(message = "Biography is required")
        String biography,
        String github,
        Boolean isBlocked,
        String jobTitle,
        String linkedIn,
        @NotNull(message = "User ID is required")
        Long userId,
        String website
) {
}
