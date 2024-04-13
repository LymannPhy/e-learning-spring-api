package co.istad.elearningspringapi.features.category;

import co.istad.elearningspringapi.base.BasedMessage;
import co.istad.elearningspringapi.features.category.dto.CategoryParentResponse;
import co.istad.elearningspringapi.features.category.dto.CategoryRequest;
import co.istad.elearningspringapi.features.category.dto.CategoryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    BasedMessage createNew(@Valid @RequestBody CategoryRequest categoryRequest){
        return categoryService.createNew(categoryRequest);
    }

    @GetMapping
    Page<CategoryResponse> findList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "25") int size
            ){
        return categoryService.findList(page, size);
    }
    @GetMapping("/{alias}")
    CategoryResponse findByAlias (@PathVariable String alias){
        return categoryService.findByAlias(alias);
    }

    @GetMapping("/parents")
    List<CategoryParentResponse> getAllParentCategoriesWithSubcategories() {
        return categoryService.getAllParentCategoriesWithSubcategories();
    }
    @PutMapping("/{alias}")
    BasedMessage updateCategoryByAlias(@PathVariable String alias,@RequestBody CategoryRequest categoryRequest){
        return categoryService.updateCategoryByAlias(alias,categoryRequest);
    }
}
