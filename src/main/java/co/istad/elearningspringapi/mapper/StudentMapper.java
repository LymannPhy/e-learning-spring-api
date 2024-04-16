package co.istad.elearningspringapi.mapper;

import co.istad.elearningspringapi.domain.Student;
import co.istad.elearningspringapi.features.student.dto.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(source = "user.username", target = "username")
    StudentResponse toStudentResponse(Student student);
}
