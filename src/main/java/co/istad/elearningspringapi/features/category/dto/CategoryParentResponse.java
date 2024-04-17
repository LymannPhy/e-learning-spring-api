package co.istad.elearningspringapi.features.category.dto;

import java.util.List;

public record CategoryParentResponse(
        String alias,
        String icon,
        String name,
        Boolean isDeleted,
        List<CategorySubCategoryResponse> subCategory
) {
}