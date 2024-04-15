package co.istad.elearningspringapi.features.student.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StudentCreateRequest(
        @NotBlank(message = "High school is required")
        String highSchool,
        @NotNull(message = "Blocked status is required")
        Boolean isBlocked,
        @NotBlank(message = "University is required")
        String university,
        @NotNull(message = "User ID is required")
        Long userId
) {
}
