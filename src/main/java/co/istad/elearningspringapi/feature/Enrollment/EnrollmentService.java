package co.istad.elearningspringapi.feature.Enrollment;

import co.istad.elearningspringapi.domain.Enrollment;
import co.istad.elearningspringapi.feature.Enrollment.dto.EnrollmentCreateRequest;
import co.istad.elearningspringapi.feature.Enrollment.dto.EnrollmentFilter;
import co.istad.elearningspringapi.feature.Enrollment.dto.EnrollmentResponse;
import org.springframework.data.domain.Page;

public interface EnrollmentService {
    Enrollment createEnrollment(EnrollmentCreateRequest enrollmentCreateRequest);
    Page<EnrollmentResponse> findAllEnrollments(int page, int size, EnrollmentFilter enrollmentFilter);
    EnrollmentResponse findEnrollmentByCode(String code);
    void updateEnrollmentProgress(String code, Integer progress);
}
