package co.istad.elearningspringapi.features.courses;

import co.istad.elearningspringapi.base.BasedMessage;
import co.istad.elearningspringapi.domain.Course;
import co.istad.elearningspringapi.features.category.CategoryRepository;
import co.istad.elearningspringapi.features.courses.dto.CourseCreateRequest;
import co.istad.elearningspringapi.features.courses.dto.CourseDetailResponse;
import co.istad.elearningspringapi.features.courses.dto.CourseResponse;
import co.istad.elearningspringapi.features.courses.dto.CourseThumbnailRequest;
import co.istad.elearningspringapi.mapper.CourseMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    @Override
    public Page<CourseResponse> getCourses(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Course> courses = courseRepository.findAll(pageRequest);
        return courses.map(courseMapper::toCourseResponse);
    }

    @Override
    public CourseDetailResponse findCourseDetailByAlias(String alias) {
        Course course = courseRepository.findAllByAlias(alias).
                orElseThrow(
                        ()->new ResponseStatusException(
                                HttpStatus.NOT_FOUND,"Course not found...!"
                        )
                );
        return courseMapper.toCourseDetailResponse(course);
    }
    @Transactional
    @Override
    public BasedMessage updateThumbnail(CourseThumbnailRequest coursethumbnailRequest, String alias) {
        if (!courseRepository.existsByAlias(alias)){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Course Not Found..."
            );
        }
        courseRepository.updateThumbnail(alias, coursethumbnailRequest.thumbnail());
        return new BasedMessage("Course Thumbnail  has been updated....!");
    }
    @Transactional
    @Override
    public BasedMessage disableCourse(String alias) {
        Course course = courseRepository.findByAlias(alias)
                .orElseThrow(
                        ()->   new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Disabled Course Not Found...!")
        );
        courseRepository.disableCourse(alias);
        return new BasedMessage("Course has been disabled....!");
    }
    @Transactional
    @Override
    public BasedMessage enableCourse(String alias) {
        Course course = courseRepository.findByAlias(alias).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Enable Course Not Found...!")
        );
        courseRepository.enableCourse(alias);
        return new BasedMessage("Course has been enabled....!");
    }
}
