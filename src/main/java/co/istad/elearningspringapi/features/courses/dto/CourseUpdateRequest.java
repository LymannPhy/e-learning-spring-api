package co.istad.elearningspringapi.features.courses.dto;

import jakarta.validation.constraints.NotBlank;

public record CourseUpdateRequest(
        @NotBlank(message = "Alias is required")
        String alias,
        String description,
        @NotBlank(message = "Title is required")
        String title
) {
}

