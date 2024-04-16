package co.istad.elearningspringapi.features.instructor.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InstructorUpdateRequest(
        @NotBlank(message = "Biography is required")
        String biography,
        @NotBlank(message = "Github is required")
        String github,
        @NotNull(message = "Blocked status is required")
        Boolean isBlocked,
        @NotBlank(message = "Job title is required")
        String jobTitle,
        @NotBlank(message = "LinkedIn is required")
        String linkedIn,
        @NotBlank(message = "Website is required")
        String website
) {
}
