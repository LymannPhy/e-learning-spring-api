package co.istad.elearningspringapi.features.category;

import co.istad.elearningspringapi.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
