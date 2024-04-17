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

    @PutMapping("/{uuid}/disable")
    void disableUserByUuid(@PathVariable String uuid){
        userService.disableUserByUuid(uuid);
    }

    @PutMapping("/{uuid}/enable")
    void enableUserByUuid(@PathVariable String uuid){
        userService.enableUserByUuid(uuid);
    }

    @DeleteMapping("/{userName}/delete")
    void deleteUserByUuid(@PathVariable String userName){
        userService.deleteUserByUserName(userName);
    }
}