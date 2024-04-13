package co.istad.elearningspringapi.feature.Enrollment;

import co.istad.elearningspringapi.domain.Enrollment;
import co.istad.elearningspringapi.feature.Enrollment.dto.EnrollmentCreateRequest;
import co.istad.elearningspringapi.feature.Enrollment.dto.EnrollmentFilter;
import co.istad.elearningspringapi.feature.Enrollment.dto.EnrollmentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/enrollment")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Enrollment createNewEnrollment(@Valid @RequestBody EnrollmentCreateRequest enrollmentCreateRequest){
        return enrollmentService.createEnrollment(enrollmentCreateRequest);
    }

    @GetMapping
    public Page<EnrollmentResponse> findAllEnrollments(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size,
                                                       @RequestParam(required = false) EnrollmentFilter enrollmentFilter
                                                       ){
        return enrollmentService.findAllEnrollments(page, size, enrollmentFilter);
    }

    @GetMapping("/{code}")
    public EnrollmentResponse findEnrollmentByCode(@PathVariable String code){
        return enrollmentService.findEnrollmentByCode(code);
    }

    @PutMapping("/{code}/progress")
    public void updateEnrollmentProgress(
            @PathVariable String code,
            @RequestParam Integer progress
    ) {
        enrollmentService.updateEnrollmentProgress(code, progress);
    }
}