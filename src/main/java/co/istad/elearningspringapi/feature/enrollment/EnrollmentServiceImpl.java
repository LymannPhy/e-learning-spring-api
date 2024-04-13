package co.istad.elearningspringapi.feature.enrollment;

import co.istad.elearningspringapi.domain.Enrollment;
import co.istad.elearningspringapi.feature.enrollment.dto.EnrollmentCreateRequest;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EnrollmentServiceImpl implements EnrollmentService{
    private final EnrollmentRepository enrollmentRepository;


    @Override
    public void createEnrollment(EnrollmentCreateRequest enrollmentCreateRequest) {

    }
}
