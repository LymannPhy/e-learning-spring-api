package co.istad.elearningspringapi.features.courses.dto;

import co.istad.elearningspringapi.domain.Category;
import co.istad.elearningspringapi.domain.Instructor;

public record CourseDetailResponse(
        String alias,
        String description,
        Boolean isDeleted,
        Boolean isFree,
        String thumbnail,
        String title,
        Category category,
        Instructor instructor

) {
}
