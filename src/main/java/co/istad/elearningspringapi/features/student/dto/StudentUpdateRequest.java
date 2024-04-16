package co.istad.elearningspringapi.features.student.dto;

import jakarta.validation.constraints.NotBlank;

public record StudentUpdateRequest(
        @NotBlank(message = "High school is required")
        String highSchool,

        @NotBlank(message = "University is required")
        String university,
        Boolean isBlocked
) {
}
