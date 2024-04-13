package co.istad.elearningspringapi.features.category.dto;

import co.istad.elearningspringapi.domain.Category;

import java.util.List;

public record CategoryParentResponse(
        String alias,
        String icon,
        String name,
        Boolean isDeleted,
        List<CategorySubCategoryResponse> subCategory
) {
}
