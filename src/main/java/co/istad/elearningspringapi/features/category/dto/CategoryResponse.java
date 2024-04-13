package co.istad.elearningspringapi.features.category.dto;

import co.istad.elearningspringapi.domain.Category;

public record CategoryResponse(
        String alias,
        String icon,
        String name,
        Boolean isDeleted,
        Category parentCategoryId
) {
}
