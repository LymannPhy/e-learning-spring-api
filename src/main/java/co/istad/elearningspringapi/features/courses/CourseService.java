package co.istad.elearningspringapi.features.courses;

import co.istad.elearningspringapi.base.BasedMessage;
import co.istad.elearningspringapi.domain.Course;
import co.istad.elearningspringapi.features.courses.dto.CourseCreateRequest;
import co.istad.elearningspringapi.features.courses.dto.CourseDetailResponse;
import co.istad.elearningspringapi.features.courses.dto.CourseResponse;
import co.istad.elearningspringapi.features.courses.dto.CourseThumbnailRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface CourseService {
    BasedMessage createCourse(CourseCreateRequest courseCreateRequest);
    Page<CourseResponse> getCourses(int page , int size);

    CourseDetailResponse findCourseDetailByAlias(String alias);
    BasedMessage updateThumbnail(CourseThumbnailRequest coursethumbnailRequest, String alias);

    BasedMessage disableCourse(String alias);

    BasedMessage enableCourse(String alias);
}
