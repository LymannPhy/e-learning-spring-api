package co.istad.elearningspringapi.feature.Enrollment.dto;

public record EnrollmentFilter(
        String code,
        String courseTitle,
        String courseCategory,
        String studentUsername,
        Boolean isCertified
) {
}
