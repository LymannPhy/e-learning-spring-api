package co.istad.elearningspringapi.feature.enrollment.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record EnrollmentCreateRequest(
        @NotBlank(message = "Code is required")
        String code,
        @NotNull(message = "Course ID is required")
        @Positive(message = "Course ID must be positive")
        Long courseId,
        @NotNull(message = "Student ID is required")
        @Positive(message = "Student ID must be positive")
        Long studentId,
        @NotNull
        LocalDateTime enrolledAt,
        @NotNull
        @Max(100)
        Integer progress
) {
}

