package co.istad.elearningspringapi.mapper;
import co.istad.elearningspringapi.domain.Course;
import co.istad.elearningspringapi.features.courses.dto.CourseCreateRequest;
import co.istad.elearningspringapi.features.courses.dto.CourseDetailResponse;
import co.istad.elearningspringapi.features.courses.dto.CourseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CourseMapper {
        @Mapping(source = "categoryId", target = "category")
        @Mapping(source = "instructorId", target = "instructor")
        Course fromCourseCreateRequest(CourseCreateRequest courseCreateRequest);
         CourseDetailResponse toCourseDetailResponse(Course course);
         CourseResponse toCourseResponse(Course course);
    }

