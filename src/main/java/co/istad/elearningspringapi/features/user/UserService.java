package co.istad.elearningspringapi.features.user;

import co.istad.elearningspringapi.features.user.dto.UserDetailsResponse;

import java.util.List;

public interface UserService {

    List<UserDetailsResponse> findUsers(String sort, String option, String filter);

    UserDetailsResponse findByUserName(String userName);

    void disableUserByUserName(String userName);

    void enableUserByUserName(String userName);

    void deleteUserByUserName(String userName);
}