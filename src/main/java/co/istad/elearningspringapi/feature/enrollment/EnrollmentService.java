package co.istad.elearningspringapi.feature.enrollment;

import co.istad.elearningspringapi.domain.Enrollment;
import co.istad.elearningspringapi.feature.enrollment.dto.EnrollmentCreateRequest;
import co.istad.elearningspringapi.feature.enrollment.dto.EnrollmentFilter;
import co.istad.elearningspringapi.feature.enrollment.dto.EnrollmentProgressResponse;
import co.istad.elearningspringapi.feature.enrollment.dto.EnrollmentResponse;
import org.springframework.data.domain.Page;

public interface EnrollmentService {
    Enrollment createEnrollment(EnrollmentCreateRequest enrollmentCreateRequest);
    Page<EnrollmentResponse> findAllEnrollments(int page, int size, EnrollmentFilter enrollmentFilter);
    EnrollmentResponse findEnrollmentByCode(String code);
    void updateEnrollmentProgress(String code, Integer progress);
    void certifyEnrollment(String code);
    EnrollmentProgressResponse findEnrollmentProgress(String code);
    void disableEnrollment(String code);
}
