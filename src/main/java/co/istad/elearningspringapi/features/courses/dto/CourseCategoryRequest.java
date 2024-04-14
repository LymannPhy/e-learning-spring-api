package co.istad.elearningspringapi.features.courses.dto;

import co.istad.elearningspringapi.domain.Category;
import jakarta.validation.constraints.NotNull;

public record CourseCategoryRequest(
        @NotNull(message = "Category ID is required")
        Category category
) {
}

