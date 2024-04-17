package co.istad.elearningspringapi.features.courses.dto;

import co.istad.elearningspringapi.domain.Category;
import co.istad.elearningspringapi.domain.Instructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseCreateRequest(
        @NotBlank(message = "Alias is required")
        String alias,
        String description,
        @NotBlank(message = "Thumbnail is required")
        String thumbnail,
        @NotBlank(message = "Title is required")
        String title,
        @NotNull(message = "Category is required")
        Category categoryId,
        @NotNull(message = "Instructor is required")
        Instructor instructorId
) {
}