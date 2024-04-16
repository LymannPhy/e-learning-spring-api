package co.istad.elearningspringapi.features.user;

import co.istad.elearningspringapi.features.user.dto.UserDetailsResponse;
import org.springframework.data.domain.Page;

public interface UserService {

    Page<UserDetailsResponse> findUsers(int page,int size, String sort);

    UserDetailsResponse findByUserName(String userName);

    void disableUserByUuid(String uuid);

    void enableUserByUuid(String uuid);

    void deleteUserByUserName(String userName);
}
