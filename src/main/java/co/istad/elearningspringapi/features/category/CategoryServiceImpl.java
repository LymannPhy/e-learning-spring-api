package co.istad.elearningspringapi.features.category;

import co.istad.elearningspringapi.base.BasedMessage;
import co.istad.elearningspringapi.domain.Category;
import co.istad.elearningspringapi.features.category.dto.CategoryParentResponse;
import co.istad.elearningspringapi.features.category.dto.CategoryRequest;
import co.istad.elearningspringapi.features.category.dto.CategoryResponse;
import co.istad.elearningspringapi.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    public List<Category> getParentCategories() {
        return categoryRepository.findByParentCategoryIsNull();
    }


    @Override
    public BasedMessage createNew(CategoryRequest categoryRequest) {
        if (categoryRepository.existsByAlias(categoryRequest.alias())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Alias are already exist in our system please try a new alias..!"
            );
        }
        if (categoryRepository.existsByName(categoryRequest.name())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Category name are already exist in our system please try a new name..!"
            );
        }
        Category category = categoryMapper.fromCategoryRequest(categoryRequest);
        category.setIsDeleted(true);
        categoryRepository.save(category);
        return new BasedMessage("Category has been added.....");
    }

    @Override
    public CategoryResponse findByAlias(String alias) {
        Category category = categoryRepository.findByAlias(alias)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Category has not been found in our system please try again..."
                        )
                );
        return categoryMapper.toCategory(category);
    }
    @Override
    public Page<CategoryResponse> findList(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Category> findAll = categoryRepository.findAll(pageRequest);
        return findAll.map(categoryMapper::toCategory);
    }

    @Override
    public List<CategoryParentResponse> findSubCategory() {
        return categoryRepository.findByParentCategoryIsNull()
                .stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BasedMessage updateCategoryByAlias(String alias,CategoryRequest categoryRequest) {
        Category updateCategory = categoryRepository.findByAlias(alias).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Category has not been found in our system please try again..."
                )
        );
        categoryMapper.fromUserUpadateRequest(categoryRequest, updateCategory);
        categoryRepository.save(updateCategory);
        return new BasedMessage("Category's has been updated...");
    }
}
