package co.istad.elearningspringapi.init;


import co.istad.elearningspringapi.domain.Authority;
import co.istad.elearningspringapi.domain.Role;
import co.istad.elearningspringapi.domain.User;
import co.istad.elearningspringapi.features.authority.AuthorityRepository;
import co.istad.elearningspringapi.features.role.RoleRepository;
import co.istad.elearningspringapi.features.user.UserRepository;
import co.istad.elearningspringapi.features.user.dto.UserDetailsResponse;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInit {

    private final RoleRepository roleRepository;
    //private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

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

        // authority init
        if(authorityRepository.count()<1){
            Authority read = new Authority();
            read.setName("read");

            Authority write = new Authority();
            write.setName("write");

            Authority update = new Authority();
            update.setName("update");

            Authority delete = new Authority();
            delete.setName("delete");

            authorityRepository.saveAll(List.of(read, write, update, delete));
        }

        // init user
        /*if (userRepository.count() < 5) {
            List<User> users = new ArrayList<>();
            users.add(createUser("vannda", "user1@gmail.com", "Phnom Penh", "Cambodia", "1133", "Kiki", "male"));
            users.add(createUser("sophat", "user2@gmail.com", "Phnom Penh", "Cambodia", "2233", "Roth", "male"));
            //users.add(createUser("chanthy", "user3@gmail.com", "Siem Reap", "Cambodia", "3333", "Chan", "female"));
            //users.add(createUser("mony", "user4@gmail.com", "Battambang", "Cambodia", "4433", "Dara", "male"));
            //users.add(createUser("soriya", "user5@gmail.com", "Kampot", "Cambodia", "5533", "Vann", "female"));

            userRepository.saveAll(users);
        }*/
    }

    /*private User createUser(String username, String email, String city, String country, String password, String familyName, String gender) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setCity(null);  // Assuming setter accepts String directly.
        user.setCountry(null);  // Assuming setter accepts String directly.
        user.setGivenName(username);
        user.setFamilyName(familyName);
        user.setDob(LocalDate.now());
        user.setGender(gender);
        user.setAddress1(city);  // Simplified for example purposes.
        user.setAddress2(city);  // Simplified for example purposes.
        user.setIsVerified(false);
        user.setVerifiedCode(UUID.randomUUID().toString());
        user.setIsDeleted(false);
        user.setUuid(UUID.randomUUID().toString());
        // Roles can be set as needed, for example by querying existing roles
        // Assume a method fetchRoleByName() that retrieves roles from the roleRepository
        List<Role> assignedRoles = new ArrayList<>();
        assignedRoles.add(fetchRoleByName("STUDENT"));
        user.setRoles(assignedRoles);

        return user;
    }
        private Role fetchRoleByName(String name) {
            return roleRepository.findByName(name).orElseThrow(() -> new RuntimeException("Role not found: " + name));
        }*/
}
