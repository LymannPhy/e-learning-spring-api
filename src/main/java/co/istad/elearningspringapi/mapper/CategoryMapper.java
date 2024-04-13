package co.istad.elearningspringapi.mapper;

import co.istad.elearningspringapi.domain.Category;
import co.istad.elearningspringapi.features.category.dto.CategoryParentResponse;
import co.istad.elearningspringapi.features.category.dto.CategoryRequest;
import co.istad.elearningspringapi.features.category.dto.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping (source = "parentCategoryId",target = "parentCategory")
    Category fromCategoryRequest(CategoryRequest categoryRequest);
    CategoryResponse toCategory (Category category);

}
