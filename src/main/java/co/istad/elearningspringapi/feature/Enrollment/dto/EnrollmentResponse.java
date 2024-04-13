package co.istad.elearningspringapi.feature.Enrollment.dto;

import java.time.LocalDateTime;

public record EnrollmentResponse(
        String code,
        Long courseId,
        Long studentId,
        LocalDateTime enrolledAt,
        Boolean isCertified,
        Integer progress
) {
}
