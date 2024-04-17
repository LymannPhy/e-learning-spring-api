package co.istad.elearningspringapi.feature.enrollment;

import co.istad.elearningspringapi.domain.Course;
import co.istad.elearningspringapi.domain.Enrollment;
import co.istad.elearningspringapi.domain.Student;
import co.istad.elearningspringapi.feature.enrollment.dto.EnrollmentCreateRequest;
import co.istad.elearningspringapi.feature.enrollment.dto.EnrollmentFilter;
import co.istad.elearningspringapi.feature.enrollment.dto.EnrollmentProgressResponse;
import co.istad.elearningspringapi.feature.enrollment.dto.EnrollmentResponse;
import co.istad.elearningspringapi.feature.courses.CourseRepository;
import co.istad.elearningspringapi.feature.student.StudentRepository;
import co.istad.elearningspringapi.map.EnrollmentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Slf4j
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final EnrollmentMapper enrollmentMapper;
    @Override
    public Enrollment createEnrollment(EnrollmentCreateRequest enrollmentCreateRequest) {
        Course course = courseRepository.findById(enrollmentCreateRequest.courseId())
                .orElseThrow(() -> new IllegalArgumentException("Course not found with id: " + enrollmentCreateRequest.courseId()));

        Student student = studentRepository.findById(enrollmentCreateRequest.studentId())
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + enrollmentCreateRequest.studentId()));

        Enrollment enrollment = new Enrollment();
        enrollment.setCode(enrollmentCreateRequest.code());
        enrollment.setCourse(course);
        enrollment.setStudent(student);
        enrollment.setEnrolledAt(enrollmentCreateRequest.enrolledAt());
        enrollment.setCertifiedAt(null);
        enrollment.setIsCertified(false);
        enrollment.setIsDeleted(false);
        enrollment.setProgress(enrollmentCreateRequest.progress());
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Page<EnrollmentResponse> findAllEnrollments(int page, int size, EnrollmentFilter enrollmentFilter) {
        if (page < 0 || size < 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Page number and size must be greater than 0"
                    );
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "enrolledAt");
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Enrollment> enrollments = enrollmentRepository.findAll(pageRequest);
        return enrollments.map(enrollment -> {
            return new EnrollmentResponse(
                    enrollment.getCode(),
                    enrollmentMapper.toCourseResponse(enrollment.getCourse()),
                    enrollmentMapper.toStudentResponse(enrollment.getStudent()),
                    enrollment.getEnrolledAt(),
                    enrollment.getIsCertified(),
                    enrollment.getProgress()
            );
        });
    }

    @Override
    public EnrollmentResponse findEnrollmentByCode(String code) {
        Enrollment enrollments = enrollmentRepository.findByCode(code)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Enrollment not found with code"
                        ));
            return new EnrollmentResponse(
                    enrollments.getCode(),
                    enrollmentMapper.toCourseResponse(enrollments.getCourse()),
                    enrollmentMapper.toStudentResponse(enrollments.getStudent()),
                    enrollments.getEnrolledAt(),
                    enrollments.getIsCertified(),
                    enrollments.getProgress()
            );
    }

    @Override
    public void updateEnrollmentProgress(String code, Integer progress) {
        Enrollment enrollment = enrollmentRepository.findByCode(code)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Enrollment not found with code"
                        ));
        enrollment.setProgress(progress);
        enrollmentRepository.save(enrollment);
    }

    @Override
    public EnrollmentProgressResponse findEnrollmentProgress(String code) {
        Enrollment enrollment = enrollmentRepository.findByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Enrollment not found with code"
                ));
        log.info("Progress: {}", enrollment.getProgress());
        return new EnrollmentProgressResponse(enrollment.getProgress());
    }

    @Override
    public void certifyEnrollment(String code) {
        Enrollment enrollment = enrollmentRepository.findByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Enrollment not found with code"
                        ));
        if (enrollment.getProgress() == 100){
            enrollment.setIsCertified(true);
            enrollmentRepository.save(enrollment);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Enrollment progress should be 100% to certify."
                    );
        }
    }

    @Override
    public void disableEnrollment(String code) {
        Enrollment enrollment = enrollmentRepository.findByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Enrollment not found with code"
                        ));
        enrollment.setIsDeleted(false);
        enrollmentRepository.save(enrollment);
    }
}