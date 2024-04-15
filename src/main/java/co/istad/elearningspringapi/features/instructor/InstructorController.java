package co.istad.elearningspringapi.features.instructor;

import co.istad.elearningspringapi.features.instructor.dto.InstructorCreateRequest;
import co.istad.elearningspringapi.features.instructor.dto.InstructorResponse;
import co.istad.elearningspringapi.features.instructor.dto.InstructorUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/instructors")
@RequiredArgsConstructor
public class InstructorController {
    private final InstructorService instructorService;
    @PostMapping
    public void createInstructor(@Validated @RequestBody InstructorCreateRequest request) {
        instructorService.createInstructor(request);
    }
    @GetMapping
    Page<InstructorResponse> findList(@RequestParam(required = false, defaultValue = "0") int page,
                                      @RequestParam(required = false, defaultValue = "25") int size){
        return instructorService.findList(page, size);
    }
    @GetMapping("/{username}")
    public InstructorResponse findInstructorByUsername(@PathVariable String username) {
       return instructorService.findInstructorByUsername(username);
    }
    @PutMapping("/{username}")
    public void updateInstructorProfile(@PathVariable String username, @RequestBody InstructorUpdateRequest request) {
        instructorService.updateInstructorProfile(username, request);
    }

}
