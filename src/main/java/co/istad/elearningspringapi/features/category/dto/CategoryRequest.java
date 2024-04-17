package co.istad.elearningspringapi.features.category.dto;

import co.istad.elearningspringapi.domain.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CategoryRequest(
        @NotBlank(message = "Alias's is required")
        String alias,

        String icon,

        @NotBlank(message = "Category's name is required")
        String name,

        Category parentCategoryId
) {
}