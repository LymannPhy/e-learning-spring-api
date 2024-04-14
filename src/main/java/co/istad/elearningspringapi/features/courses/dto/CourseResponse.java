package co.istad.elearningspringapi.features.courses.dto;
import co.istad.elearningspringapi.domain.Category;
public record CourseResponse(
        String alias,
        String description,
        Boolean isDeleted,
        Boolean  isFree,
        String thumbnail,
        String title
) {
}
