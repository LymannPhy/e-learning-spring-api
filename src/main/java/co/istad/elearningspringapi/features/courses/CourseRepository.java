package co.istad.elearningspringapi.features.courses;

import co.istad.elearningspringapi.domain.Category;
import co.istad.elearningspringapi.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Boolean existsByAlias(String alias);
    Optional<Course> findByAlias(String alias);
    @Modifying
    @Query("update Course AS c set c.thumbnail = ?2 where c.alias =?1")
    void updateThumbnail(String alias, String thumbnail);
    Optional<Course> findAllByAlias(String alias);
    @Modifying
    @Query("UPDATE Course c SET c.isDeleted = true WHERE c.alias = :alias")
    void disableCourse(String alias);
    @Modifying
    @Query("update Course as c set c.isDeleted=false where c.alias=:alias")
    void enableCourse(String alias);
    @Modifying
    @Query("update Course as c set c.category = :category where c.alias = :alias")
    void updateCourseCategory(@Param("alias") String alias, @Param("category") Category category);

}