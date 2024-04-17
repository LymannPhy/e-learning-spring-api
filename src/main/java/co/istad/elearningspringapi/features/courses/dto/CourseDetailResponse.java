package co.istad.elearningspringapi.features.courses.dto;

import co.istad.elearningspringapi.domain.Category;
import co.istad.elearningspringapi.domain.Instructor;
import co.istad.elearningspringapi.features.category.dto.CategorySnippingResponse;
import co.istad.elearningspringapi.features.instructor.dto.InstructorSnippingResponse;

public record CourseDetailResponse(
        String alias,
        String description,
        Boolean isDeleted,
        Boolean isFree,
        String thumbnail,
        String title,
        CategorySnippingResponse category,
        InstructorSnippingResponse instructor

) {
}
