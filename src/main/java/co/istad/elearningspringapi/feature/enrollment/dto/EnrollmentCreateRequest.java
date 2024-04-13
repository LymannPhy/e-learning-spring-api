package co.istad.elearningspringapi.feature.enrollment.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record EnrollmentCreateRequest(
        @NotBlank
        String code,
        @NotNull
        Long courseId,
        @NotNull
        Long studentId,
        @NotNull
        LocalDateTime enrolledAt
) {
}
