package co.istad.elearningspringapi.feature.enrollment;

import co.istad.elearningspringapi.feature.enrollment.dto.EnrollmentCreateRequest;

public interface EnrollmentService {
    void createEnrollment(EnrollmentCreateRequest enrollmentCreateRequest);
}
