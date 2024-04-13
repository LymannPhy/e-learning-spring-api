package co.istad.elearningspringapi.features.category;

import co.istad.elearningspringapi.domain.Category;
import co.istad.elearningspringapi.features.category.dto.CategorySubCategoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    Boolean existsByAlias(String alias);
    Boolean existsByName(String name);
    Optional<Category> findByAlias(String alias);
//    @Query("SELECT c FROM Category c WHERE c.parentCategory IS NULL")
//    List<Category> findAllWithSubcategories();


    List<Category> findByParentCategoryIsNull();

}
