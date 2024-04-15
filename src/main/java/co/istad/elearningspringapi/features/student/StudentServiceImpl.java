package co.istad.elearningspringapi.features.student;

import co.istad.elearningspringapi.domain.Student;
import co.istad.elearningspringapi.domain.User;
import co.istad.elearningspringapi.features.student.dto.StudentCreateRequest;
import co.istad.elearningspringapi.features.student.dto.StudentResponse;
import co.istad.elearningspringapi.features.student.dto.StudentUpdateRequest;
import co.istad.elearningspringapi.features.user.UserRepository;
import co.istad.elearningspringapi.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final StudentMapper studentMapper;
    @Override
    public void createStudent(StudentCreateRequest studentCreateRequest) {
        // Check if the user with the provided ID exists
        User user = userRepository.findById(studentCreateRequest.userId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with ID: " + studentCreateRequest.userId()));

        Student student = new Student();
        student.setHighSchool(studentCreateRequest.highSchool());
        student.setIsBlocked(studentCreateRequest.isBlocked());
        student.setUniversity(studentCreateRequest.university());
        student.setUser(user);

        studentRepository.save(student);
    }
    @Override
    public Page<StudentResponse> findStudents(int page, int size) {
        // Validate page and size
        if (page < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Page must be greater than or equal to zero");
        }
        if (size < 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Size must be greater than or equal to one");
        }

        Sort sortByUsername = Sort.by(Sort.Direction.ASC, "user.username");
        PageRequest pageRequest = PageRequest.of(page, size, sortByUsername);
        Page<Student> studentsPage = studentRepository.findAll(pageRequest);

        return studentsPage.map(studentMapper::toStudentResponse);
    }
    @Override
    public StudentResponse findStudentByUsername(String username) {
        Student student = studentRepository.findByUserUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with username: " + username));
        return studentMapper.toStudentResponse(student);
    }

    @Override
    public StudentResponse updateStudentProfile(String username, StudentUpdateRequest studentUpdateRequest) {
        Student student = studentRepository.findByUserUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with username: " + username));

        student.setHighSchool(studentUpdateRequest.highSchool());
        student.setUniversity(studentUpdateRequest.university());
        student.setIsBlocked(studentUpdateRequest.isBlocked());

        return studentMapper.toStudentResponse(student);
    }

}
