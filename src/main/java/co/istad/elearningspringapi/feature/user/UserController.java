package co.istad.elearningspringapi.feature.user;

import co.istad.elearningspringapi.feature.user.dto.UserDetailsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/")
public class UserController {

    private final UserService userService;

    @GetMapping
    Page<UserDetailsResponse> findUsers(@RequestParam(required = false, defaultValue = "0") int page,
                               @RequestParam(required = false, defaultValue = "4") int size,
                               @RequestParam(required = false, defaultValue = "asc") String sort){
        return userService.findUsers(page, size, sort);
    }

    @GetMapping("{userName}")
    UserDetailsResponse findByUserName(@PathVariable String userName){
        return userService.findByUserName(userName);
    }
}
