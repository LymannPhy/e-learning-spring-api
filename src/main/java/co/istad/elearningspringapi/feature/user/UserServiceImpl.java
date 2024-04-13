package co.istad.elearningspringapi.feature.user;

import co.istad.elearningspringapi.domain.User;
import co.istad.elearningspringapi.feature.user.dto.UserDetailsResponse;
import co.istad.elearningspringapi.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
