package co.istad.elearningspringapi.mapper;

import co.istad.elearningspringapi.domain.Instructor;
import co.istad.elearningspringapi.features.instructor.dto.InstructorCreateRequest;
import co.istad.elearningspringapi.features.instructor.dto.InstructorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InstructorMapper {

    InstructorMapper INSTANCE = Mappers.getMapper(InstructorMapper.class);

    Instructor toInstructor(InstructorCreateRequest instructorCreateRequest);

    InstructorResponse toInstructorResponse(Instructor instructor);
}
