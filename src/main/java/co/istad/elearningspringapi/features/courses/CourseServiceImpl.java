package co.istad.elearningspringapi.features.courses;

import co.istad.elearningspringapi.base.BasedMessage;
import co.istad.elearningspringapi.domain.Course;
import co.istad.elearningspringapi.features.courses.dto.CourseCreateRequest;
import co.istad.elearningspringapi.mapper.CourseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    @Override
    public BasedMessage createCourse(CourseCreateRequest courseCreateRequest) {
        if (courseRepository.existsByAlias(courseCreateRequest.alias())){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Alias are already existing in our system..!"
            );
        }
        //logic here
        Course course = courseMapper.fromCourseCreateRequest(courseCreateRequest);
        course.setIsDeleted(false);
        course.setIsFree(false);
        courseRepository.save(course);
        return new BasedMessage("Course has been added....!");
    }
}
