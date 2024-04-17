package co.istad.elearningspringapi.features.user;

import co.istad.elearningspringapi.features.user.dto.UserDetailsResponse;

import java.util.List;

public interface UserService {

    List<UserDetailsResponse> findUsers(String sort, String option, String filter);

    UserDetailsResponse findByUserName(String userName);

    void disableUserByUuid(String uuid);

    void enableUserByUuid(String uuid);

    void deleteUserByUserName(String userName);
}
