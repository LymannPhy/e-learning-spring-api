package co.istad.elearningspringapi.features.user;

import co.istad.elearningspringapi.domain.User;
import co.istad.elearningspringapi.features.user.dto.UserDetailsResponse;
import co.istad.elearningspringapi.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public List<UserDetailsResponse> findUsers(String sort, String option, String filter) {
        Sort sortById;
        if (sort.equalsIgnoreCase("desc")) {
            sortById = Sort.by(Sort.Direction.DESC, "id");
        } else {
            sortById = Sort.by(Sort.Direction.ASC, "id");
        }

        List<User> userList;

        if (option.equalsIgnoreCase("userName")) {
            userList = userRepository.findByUsernameContaining(filter)
                    .orElseThrow(() ->
                            new ResponseStatusException(
                                    HttpStatus.NOT_FOUND,
                                    "Username has been not found: " + filter
                            ));
            if (userList.isEmpty()){
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Username has been not found: " + filter
                );
            }
        }

        else if (option.equalsIgnoreCase("email")) {
            userList = userRepository.findByEmailContaining(filter)
                    .orElseThrow(() ->
                            new ResponseStatusException(
                                    HttpStatus.NOT_FOUND,
                                    "Email has been not found: " + filter
                            ));
            if (userList.isEmpty()){
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Username been not found: " + filter
                );
            }
        }

         else if (option.equalsIgnoreCase("nationalIdCard")) {
            userList = userRepository.findByNationalIdCardContaining(filter)
                    .orElseThrow(() ->
                            new ResponseStatusException(
                                    HttpStatus.NOT_FOUND,
                                    "nationalIdCard has been not found: " + filter
                            ));
            if (userList.isEmpty()){
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "NationalIdCard been not found: " + filter
                );
            }
        }

         else if (option.equalsIgnoreCase("phoneNumber")) {
            userList = userRepository.findByPhoneNumberContaining(filter)
                    .orElseThrow(() ->
                            new ResponseStatusException(
                                    HttpStatus.NOT_FOUND,
                                    "phoneNumber has been not found: " + filter
                            ));
            if (userList.isEmpty()){
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "phoneNumber been not found: " + filter
                );
            }
        }

         else if (option.equalsIgnoreCase("gender")) {
            userList = userRepository.findByGenderContaining(filter)
                    .orElseThrow(() ->
                            new ResponseStatusException(
                                    HttpStatus.NOT_FOUND,
                                    "gender has been not found: " + filter
                            ));
            if (userList.isEmpty()){
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "gender been not found: " + filter
                );
            }
        }

        else if (option.equalsIgnoreCase("familyName")) {
            userList = userRepository.findByFamilyName(filter)
                    .orElseThrow(() ->
                            new ResponseStatusException(
                                    HttpStatus.NOT_FOUND,
                                    "familyName has been not found: " + filter
                            ));
            if (userList.isEmpty()){
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "familyName been not found: " + filter
                );
            }
        }

        else if (option.equalsIgnoreCase("givenName")) {
            userList = userRepository.findByGivenName(filter)
                    .orElseThrow(() ->
                            new ResponseStatusException(
                                    HttpStatus.NOT_FOUND,
                                    "givenName has been not found: " + filter
                            ));
            if (userList.isEmpty()){
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "givenName been not found: " + filter
                );
            }
        }

         else if (option.equalsIgnoreCase("roles")) {
            userList = userRepository.findByRolesContaining(filter)
                    .orElseThrow(() ->
                            new ResponseStatusException(
                                    HttpStatus.NOT_FOUND,
                                    "roles has been not found: " + filter
                            ));
            if (userList.isEmpty()){
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "roles been not found: " + filter
                );
            }
        }
        else {
            userList = userRepository.findAll(sortById);
        }

        return userMapper.toUserDetailsResponseList(userList);
    }

    @Override
    public UserDetailsResponse findByUserName(String userName) {
        // check if userName exist
        User user = userRepository.findByUsername(userName)
                .orElseThrow(()->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "userName has been found"
                        ));
        return userMapper.toUserDetailsResponse(user);
    }

    @Override
    public void disableUserByUuid(String uuid) {
        User user = userRepository.findByUuid(uuid)
                .orElseThrow(()->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "User has been not found...!"
                        ));
        user.setIsDeleted(true);
        userRepository.save(user);
    }

    @Override
    public void enableUserByUuid(String uuid) {
        User user = userRepository.findByUuid(uuid)
                .orElseThrow(()->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "User has been not found...!"
                        ));
        user.setIsDeleted(false);
        userRepository.save(user);
    }

    @Override
    public void deleteUserByUserName(String userName) {
        User user = userRepository.findByUsername(userName)
                .orElseThrow(()->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "User has been not found"
                        ));
        userRepository.delete(user);
    }
}