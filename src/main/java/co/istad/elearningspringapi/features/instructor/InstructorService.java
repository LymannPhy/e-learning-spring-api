package co.istad.elearningspringapi.features.instructor;

import co.istad.elearningspringapi.features.instructor.dto.InstructorCreateRequest;
import co.istad.elearningspringapi.features.instructor.dto.InstructorResponse;
import co.istad.elearningspringapi.features.instructor.dto.InstructorUpdateRequest;
import org.springframework.data.domain.Page;

public interface InstructorService {
    void createInstructor(InstructorCreateRequest instructorCreateRequest);
    Page<InstructorResponse> findList(int page, int size);
    InstructorResponse findInstructorByUsername(String username);
    void updateInstructorProfile(String username, InstructorUpdateRequest instructorUpdateRequest);
}
