package co.istad.elearningspringapi.init;


import co.istad.elearningspringapi.domain.Role;
import co.istad.elearningspringapi.features.role.RoleRepository;
import co.istad.elearningspringapi.features.user.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInit {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @PostConstruct
    void init(){
        // init role
        if (roleRepository.count() < 1){
            Role student = new Role();
            student.setName("STUDENT");

            Role instructor = new Role();
            instructor.setName("INSTRUCTOR");

            Role user = new Role();
            user.setName("USER");

            Role admin = new Role();
            admin.setName("ADMIN");

            roleRepository.saveAll(List.of(student, instructor, user, admin));
        }

        // init user
        /*if (userRepository.count() < 2) {
            List<User> users = new ArrayList<>();

            User user1 = new User();
            user1.setUsername("user1");
            user1.setPassword("password1");
            user1.setEmail("user1@example.com");

            User user2 = new User();
            user2.setUsername("user2");
            user2.setPassword("password2");
            user2.setEmail("user2@example.com");

            users.add(user1);
            users.add(user2);

            userRepository.saveAll(users);
        }*/
    }

}
