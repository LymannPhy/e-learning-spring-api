package co.istad.elearningspringapi.map;

import co.istad.elearningspringapi.domain.Enrollment;
import co.istad.elearningspringapi.feature.enrollment.dto.EnrollmentResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {
    EnrollmentResponse toAccountResponse(Enrollment enrollment);

}
