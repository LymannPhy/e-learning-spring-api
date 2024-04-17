package co.istad.elearningspringapi.feature.enrollment.dto;

import co.istad.elearningspringapi.feature.courses.dto.CourseResponse;
import co.istad.elearningspringapi.feature.student.dto.StudentResponse;

import java.time.LocalDateTime;

public record EnrollmentResponse(
        String code,
        CourseResponse courseId,
        StudentResponse studentId,
        LocalDateTime enrolledAt,
        Boolean isCertified,
        Boolean isDeleted,
        Integer progress
) {
}