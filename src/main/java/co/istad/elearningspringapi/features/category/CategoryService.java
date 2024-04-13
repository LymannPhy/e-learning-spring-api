package co.istad.elearningspringapi.features.category;

import co.istad.elearningspringapi.base.BasedMessage;
import co.istad.elearningspringapi.domain.Category;
import co.istad.elearningspringapi.features.category.dto.CategoryParentResponse;
import co.istad.elearningspringapi.features.category.dto.CategoryRequest;
import co.istad.elearningspringapi.features.category.dto.CategoryResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    BasedMessage createNew (CategoryRequest categoryRequest);
    CategoryResponse findByAlias(String alias);
    Page<CategoryResponse> findList(int page,int size);


    BasedMessage updateCategoryByAlias(String alias,CategoryRequest categoryRequest);

    List<CategoryParentResponse> getAllParentCategoriesWithSubcategories();
}
