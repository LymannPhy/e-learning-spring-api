package co.istad.elearningspringapi.feature.enrollment.dto;

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
