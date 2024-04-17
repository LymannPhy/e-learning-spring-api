package co.istad.elearningspringapi.features.user;

import co.istad.elearningspringapi.domain.Role;
import co.istad.elearningspringapi.domain.User;
import co.istad.elearningspringapi.features.user.dto.UserDetailsResponse;
import co.istad.elearningspringapi.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Page<UserDetailsResponse> findUsers(int page, int size, String sort) {
        // validate page and size
        if(page < 0){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Page number must be grater than 0");
        }
        if(size < 1){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "size number must be grater than or equal 1");
        }

        Sort sort1;
        if(sort.equalsIgnoreCase("desc")){
            sort1 = Sort.by(Sort.Direction.DESC,"id");
        }
        else {
            sort1 = Sort.by(Sort.Direction.ASC,"id");
        }
        Sort sortById = sort1;
        PageRequest pageRequest = PageRequest.of(page, size, sortById);
        Page<User> users = userRepository.findAll(pageRequest);
        return users.map(userMapper::toUserDetailsResponse);
    }

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
                                    "Username not found: " + filter
                            ));
        } else if (option.equalsIgnoreCase("email")) {
            userList = userRepository.findByEmailContaining(filter);
        } else if (option.equalsIgnoreCase("nationalIdCard")) {
            userList = userRepository.findByNationalIdCardContaining(filter);
        } else if (option.equalsIgnoreCase("phoneNumber")) {
            userList = userRepository.findByPhoneNumberContaining(filter);
        } else if (option.equalsIgnoreCase("gender")) {
            userList = userRepository.findByGenderContaining(filter);
        } else {
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
