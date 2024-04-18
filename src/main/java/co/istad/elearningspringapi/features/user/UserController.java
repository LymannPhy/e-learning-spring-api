package co.istad.elearningspringapi.features.user;

import co.istad.elearningspringapi.features.user.dto.UserDetailsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    List<UserDetailsResponse> findUsers(@RequestParam(required = false, defaultValue = "asc") String sort,
                                        @RequestParam(required = false, defaultValue = "all") String option,
                                        @RequestParam(required = false, defaultValue = "default") String filter){
        return userService.findUsers(sort, option, filter);
    }

    @GetMapping("/{userName}")
    UserDetailsResponse findByUserName(@PathVariable String userName){
        return userService.findByUserName(userName);
    }

    @PutMapping("/{userName}/disable")
    void disableUserByUserName(@PathVariable String userName){
        userService.disableUserByUserName(userName);
    }

    @PutMapping("/{userName}/enable")
    void enableUserByUuid(@PathVariable String userName){
        userService.enableUserByUserName(userName);
    }

    @DeleteMapping("/{userName}/delete")
    void deleteUserByUuid(@PathVariable String userName){
        userService.deleteUserByUserName(userName);
    }
}