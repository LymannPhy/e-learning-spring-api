package co.istad.elearningspringapi.features.courses;

import co.istad.elearningspringapi.base.BasedMessage;
import co.istad.elearningspringapi.domain.Course;
import co.istad.elearningspringapi.features.courses.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface CourseService {
    BasedMessage createCourse(CourseCreateRequest courseCreateRequest);
    Page<CourseResponse> getCourses(int page , int size);

    CourseDetailResponse findCourseDetailByAlias(String alias);
    BasedMessage updateThumbnail(CourseThumbnailRequest coursethumbnailRequest, String alias);

    BasedMessage disableCourse(String alias);

    BasedMessage enableCourse(String alias);
    BasedMessage updateCourseByAlias(String alias, CourseUpdateRequest courseUpdateRequest);
    BasedMessage updateCourseCategory(String alias,CourseCategoryRequest courseCategoryRequest);

}
