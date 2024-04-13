package co.istad.elearningspringapi.mapper;

import co.istad.elearningspringapi.domain.Category;
import co.istad.elearningspringapi.features.category.dto.CategoryParentResponse;
import co.istad.elearningspringapi.features.category.dto.CategoryRequest;
import co.istad.elearningspringapi.features.category.dto.CategoryResponse;
import co.istad.elearningspringapi.features.category.dto.CategorySubCategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(source = "parentCategoryId", target = "parentCategory")
    Category fromCategoryRequest(CategoryRequest categoryRequest);

    @Mapping(source = "parentCategory", target = "parentCategoryId")
    CategoryResponse toCategory(Category category);

    CategoryParentResponse toDto(Category category);

    @Mapping(source = "parentCategoryId", target = "parentCategory")
    void fromUserUpadateRequest(CategoryRequest categoryRequest, @MappingTarget Category category);

    @Mapping(source = "parentCategory",target = "subCategory")
    List<CategoryParentResponse> toCategoryParentResponse(List<Category> categories);

}
