package co.istad.elearningspringapi.feature.courses.dto;

public record CourseResponse(
        Long id,
        String alias,
        String title,
        String description,
        Boolean isFree,
        String thumbnail
) {
}
