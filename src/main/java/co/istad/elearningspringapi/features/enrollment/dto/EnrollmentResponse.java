package co.istad.elearningspringapi.features.enrollment.dto;

import co.istad.elearningspringapi.features.courses.dto.CourseResponse;
import co.istad.elearningspringapi.features.student.dto.StudentResponse;

import java.time.LocalDateTime;

public record EnrollmentResponse(
        String code,
        CourseResponse course,
        StudentResponse student,
        LocalDateTime enrolledAt,
        Boolean isCertified,
        Boolean isDeleted,
        Integer progress
) {
}