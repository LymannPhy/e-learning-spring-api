package co.istad.elearningspringapi.feature.enrollment;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/enrollment")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;
}
