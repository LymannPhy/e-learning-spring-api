package co.istad.elearningspringapi.features.student;

import co.istad.elearningspringapi.features.student.dto.StudentCreateRequest;
import co.istad.elearningspringapi.features.student.dto.StudentResponse;
import co.istad.elearningspringapi.features.student.dto.StudentUpdateRequest;
import org.springframework.data.domain.Page;

public interface StudentService {
    void createStudent(StudentCreateRequest studentCreateRequest);
    Page<StudentResponse> findStudents(int page, int size);
    StudentResponse findStudentByUsername(String username);

    StudentResponse updateStudentProfile(String username, StudentUpdateRequest studentUpdateRequest);
}
