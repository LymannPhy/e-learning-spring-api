package co.istad.elearningspringapi.features.category;

import co.istad.elearningspringapi.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    Boolean existsByAlias(String alias);
    Boolean existsByName(String name);
    Optional<Category> findByAlias(String alias);
//    @Query("SELECT c FROM Category c WHERE c.parentCategory IS NULL")
//    List<Category> findAllWithSubcategories();

    List<Category> findByParentCategoryIn(List<Category> parentCategories);

    List<Category> findByParentCategoryIsNull();
}
