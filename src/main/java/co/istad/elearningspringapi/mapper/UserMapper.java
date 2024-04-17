package co.istad.elearningspringapi.mapper;


import co.istad.elearningspringapi.domain.User;
import co.istad.elearningspringapi.features.user.dto.UserDetailsResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDetailsResponse toUserDetailsResponse(User user);

    List<UserDetailsResponse> toUserDetailsResponseList(List<User> userList);
}
