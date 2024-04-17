package co.istad.elearningspringapi.features.category;

import co.istad.elearningspringapi.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Boolean existsByAlias(String alias);

    Boolean existsByName(String name);

    Optional<Category> findByAlias(String alias);
//    @Query("SELECT c FROM Category c WHERE c.parentCategory IS NULL")

    List<Category> findByParentCategoryIsNull();

    List<Category> findByParentCategory(Category parentCategory);

    @Modifying
    @Query("UPDATE Category c SET c.isDeleted = false WHERE c.alias = :alias")
    void disableCategory(String alias);

    @Modifying
    @Query("update Category as c set c.isDeleted=true where c.alias=:alias")
    void enableCategory(String alias);
}