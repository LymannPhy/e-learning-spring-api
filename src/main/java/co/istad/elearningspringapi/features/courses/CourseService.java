package co.istad.elearningspringapi.features.courses;

import co.istad.elearningspringapi.base.BasedMessage;
import co.istad.elearningspringapi.domain.Course;
import co.istad.elearningspringapi.features.courses.dto.CourseCreateRequest;

public interface CourseService {
    BasedMessage createCourse(CourseCreateRequest courseCreateRequest);
}
