package co.istad.elearningspringapi.feature.Enrollment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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

