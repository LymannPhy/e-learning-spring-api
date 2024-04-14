package co.istad.elearningspringapi.features.courses;

import co.istad.elearningspringapi.base.BasedMessage;
import co.istad.elearningspringapi.features.courses.dto.*;
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
    @GetMapping("/{alias}")
    CourseDetailResponse findDetail (@PathVariable String alias){
        return courseService.findCourseDetailByAlias(alias);
    }
    @PutMapping("/{alias}/disable")
    BasedMessage disableCourse(@PathVariable String alias) {
        return courseService.disableCourse(alias);
    }
    @PutMapping("/{alias}/enable")
    BasedMessage enableCourse(@PathVariable String alias){
        return courseService.enableCourse(alias);
    }
    //UPDATE COURSE
    @PutMapping("/{alias}")
    BasedMessage updateCourseByAlias(@PathVariable String alias, @Valid @RequestBody CourseUpdateRequest courseUpdateRequest){
        return courseService.updateCourseByAlias(alias,courseUpdateRequest);
    }

    // UPDATE COURSE CATEGORY
    @PutMapping("/{alias}/categories")
    BasedMessage updateCourseCategory (@PathVariable String alias, @Valid @RequestBody CourseCategoryRequest courseCategoryRequest){
        return courseService.updateCourseCategory(alias,courseCategoryRequest);
    }

}
