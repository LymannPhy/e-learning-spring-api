package co.istad.elearningspringapi.features.student;

import co.istad.elearningspringapi.features.student.dto.StudentCreateRequest;
import co.istad.elearningspringapi.features.student.dto.StudentResponse;
import co.istad.elearningspringapi.features.student.dto.StudentUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @PostMapping
    public void createStudent(@RequestBody StudentCreateRequest request) {
        studentService.createStudent(request);
    }
    @GetMapping
    public Page<StudentResponse> findStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
    return studentService.findStudents(page, size);
    }
    @GetMapping("/{username}")
    StudentResponse findStudentProfile(@PathVariable String username) {
        return studentService.findStudentByUsername(username);
    }
    @PutMapping("/{username}")
    public void updateStudentProfile(@PathVariable String username, @Valid @RequestBody StudentUpdateRequest studentUpdateRequest) {
        studentService.updateStudentProfile(username, studentUpdateRequest);
    }
}
