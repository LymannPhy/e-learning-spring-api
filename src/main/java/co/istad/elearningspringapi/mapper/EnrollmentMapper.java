package co.istad.elearningspringapi.mapper;

import co.istad.elearningspringapi.domain.Course;
import co.istad.elearningspringapi.domain.Enrollment;
import co.istad.elearningspringapi.domain.Student;
import co.istad.elearningspringapi.feature.courses.dto.CourseResponse;
import co.istad.elearningspringapi.feature.enrollment.dto.EnrollmentResponse;
import co.istad.elearningspringapi.feature.student.dto.StudentResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {
        Student.class,
        Course.class})
public interface EnrollmentMapper {
    EnrollmentResponse toEnrollmentResponse(Enrollment enrollment);
    StudentResponse toStudentResponse(Student student);

    CourseResponse toCourseResponse(Course course);
}
