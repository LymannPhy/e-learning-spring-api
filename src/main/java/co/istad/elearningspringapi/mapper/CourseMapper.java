package co.istad.elearningspringapi.mapper;
import co.istad.elearningspringapi.domain.Course;
import co.istad.elearningspringapi.features.courses.dto.CourseCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {
        @Mapping(source = "categoryId", target = "category")
        @Mapping(source = "instructorId", target = "instructor")
        Course fromCourseCreateRequest(CourseCreateRequest courseCreateRequest);
    }

