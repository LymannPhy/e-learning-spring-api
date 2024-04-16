package co.istad.elearningspringapi.features.instructor;

import co.istad.elearningspringapi.domain.Instructor;
import co.istad.elearningspringapi.domain.User;
import co.istad.elearningspringapi.features.instructor.dto.InstructorCreateRequest;
import co.istad.elearningspringapi.features.instructor.dto.InstructorResponse;
import co.istad.elearningspringapi.features.instructor.dto.InstructorUpdateRequest;
import co.istad.elearningspringapi.features.user.UserRepository;
import co.istad.elearningspringapi.mapper.InstructorMapper;
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
public class InstructorServiceImpl implements InstructorService{
    private final InstructorRepository instructorRepository;
    private final UserRepository userRepository;
    private final InstructorMapper instructorMapper;
    @Override
    public void createInstructor(InstructorCreateRequest instructorCreateRequest) {
        // Check if the user with the provided ID exists
        User user = userRepository.findById(instructorCreateRequest.userId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        Instructor instructor = instructorMapper.toInstructor(instructorCreateRequest);
        instructor.setUser(user);
        instructorRepository.save(instructor);
    }

    @Override
    public Page<InstructorResponse> findList(int page, int size) {
        //validate page and size
        if(page < 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Page must be greater than or equal to zero");
        }
        if(size < 1){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Size must be greater than or equal to one");
        }
        Sort sortByInstName = Sort.by(Sort.Direction.ASC, "jobTitle");

        PageRequest pageRequest = PageRequest.of(page, size, sortByInstName);
        Page<Instructor> instructors = instructorRepository.findAll(pageRequest);
        return instructors.map(instructorMapper::toInstructorResponse);
    }

    @Override
    public InstructorResponse findInstructorByUsername(String username) {
        // Find the user by username
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with username: " + username));

        // Find the instructor associated with the user
        Instructor instructor = user.getInstructor();
        if (instructor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor not found for user with username: " + username);
        }

        // Map the instructor entity to DTO
        return instructorMapper.toInstructorResponse(instructor);
    }

    @Override
    public void updateInstructorProfile(String username, InstructorUpdateRequest instructorUpdateRequest) {
        // Find the user by username
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with username: " + username));

        // Find the instructor associated with the user
        Instructor instructor = user.getInstructor();
        if (instructor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor not found for user with username: " + username);
        }

        instructor.setBiography(instructorUpdateRequest.biography());
        instructor.setGithub(instructorUpdateRequest.github());
        instructor.setIsBlocked(instructorUpdateRequest.isBlocked());
        instructor.setJobTitle(instructorUpdateRequest.jobTitle());
        instructor.setLinkedIn(instructorUpdateRequest.linkedIn());
        instructor.setWebsite(instructorUpdateRequest.website());

        instructorRepository.save(instructor);
    }
}
