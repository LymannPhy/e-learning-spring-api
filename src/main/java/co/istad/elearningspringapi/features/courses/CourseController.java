package co.istad.elearningspringapi.features.courses;

import co.istad.elearningspringapi.base.BasedMessage;
import co.istad.elearningspringapi.features.courses.dto.CourseCreateRequest;
import co.istad.elearningspringapi.features.courses.dto.CourseResponse;
import co.istad.elearningspringapi.features.courses.dto.CourseThumbnailRequest;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    @GetMapping
   Page<CourseResponse> allCourses(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "25") int size
    ){
        return courseService.getCourses(page, size);
    }
    @PutMapping("/{alias}/thumbnail")
   BasedMessage thumbnail(@Valid @RequestBody CourseThumbnailRequest courseThumbnailRequest , @PathVariable String alias){
        return courseService.updateThumbnail(courseThumbnailRequest,alias);
    }
}
