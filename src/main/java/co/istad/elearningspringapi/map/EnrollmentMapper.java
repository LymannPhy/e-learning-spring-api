package co.istad.elearningspringapi.map;

import co.istad.elearningspringapi.domain.Enrollment;
import co.istad.elearningspringapi.feature.Enrollment.dto.EnrollmentCreateRequest;
import co.istad.elearningspringapi.feature.Enrollment.dto.EnrollmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {
    EnrollmentResponse toAccountResponse(Enrollment enrollment);

}
