package co.istad.elearningspringapi.mapper;

import co.istad.elearningspringapi.domain.Course;
import co.istad.elearningspringapi.domain.Enrollment;
import co.istad.elearningspringapi.domain.Student;
import co.istad.elearningspringapi.features.courses.dto.CourseResponse;
import co.istad.elearningspringapi.features.enrollment.dto.EnrollmentResponse;
import co.istad.elearningspringapi.features.student.dto.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {
    @Mapping(source = "course", target = "course")
    @Mapping(source = "student", target = "student")
    EnrollmentResponse toEnrollmentResponse(Enrollment enrollment);

    StudentResponse toStudentResponse(Student student);

    CourseResponse toCourseResponse(Course course);
}
