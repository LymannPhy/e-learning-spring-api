package co.istad.elearningspringapi.feature.enrollment.dto;

public record EnrollmentFilter(
        String code,
        String courseTitle,
        String courseCategory,
        String studentUsername,
        Boolean isCertified
) {
}
