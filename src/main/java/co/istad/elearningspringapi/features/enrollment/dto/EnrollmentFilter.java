package co.istad.elearningspringapi.features.enrollment.dto;

public record EnrollmentFilter(
        String code,
        String courseTitle,
        String courseCategory,
        String studentUsername,
        Boolean isCertified
) {
}