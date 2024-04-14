package co.istad.elearningspringapi.features.courses;

import co.istad.elearningspringapi.base.BasedMessage;
import co.istad.elearningspringapi.features.courses.dto.CourseCreateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;
    private final CourseRepository courseRepository;
    @PostMapping
    BasedMessage createNew(@Valid @RequestBody CourseCreateRequest courseCreateRequest){
        return courseService.createCourse(courseCreateRequest);
    }

}
