package co.istad.elearningspringapi.features.user;

import co.istad.elearningspringapi.features.user.dto.UserDetailsResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    Page<UserDetailsResponse> findUsers(int page,int size, String sort);

    List<UserDetailsResponse> findUsers(String sort, String option, String filter);

    UserDetailsResponse findByUserName(String userName);

    void disableUserByUuid(String uuid);

    void enableUserByUuid(String uuid);

    void deleteUserByUserName(String userName);
}
