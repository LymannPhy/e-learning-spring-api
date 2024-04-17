package co.istad.elearningspringapi.init;


import co.istad.elearningspringapi.domain.Authority;
import co.istad.elearningspringapi.domain.Role;
import co.istad.elearningspringapi.domain.User;
import co.istad.elearningspringapi.features.authority.AuthorityRepository;
import co.istad.elearningspringapi.features.role.RoleRepository;
import co.istad.elearningspringapi.features.user.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInit {

    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;
    private final UserRepository userRepository;

    @PostConstruct
    void init(){

        // init authorities
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

        // init roles
        if (roleRepository.count() < 1){
            Role student = new Role();
            student.setName("STUDENT");

            Role instructor = new Role();
            instructor.setName("INSTRUCTOR");

            Role user = new Role();
            user.setName("USER");

            Role admin = new Role();
            admin.setName("ADMIN");

            // set authority for each role
            Authority readAuthority = authorityRepository.findById(1L)
                    .orElseThrow(() -> new RuntimeException("Authority not found: read"));
            Authority writeAuthority = authorityRepository.findById(2L)
                    .orElseThrow(() -> new RuntimeException("Authority not found: write"));
            Authority updateAuthority = authorityRepository.findById(3L)
                    .orElseThrow(() -> new RuntimeException("Authority not found: update"));
            Authority deleteAuthority = authorityRepository.findById(4L)
                    .orElseThrow(() -> new RuntimeException("Authority not found: delete"));

            student.setAuthorities(List.of(readAuthority));
            instructor.setAuthorities(List.of(writeAuthority, updateAuthority, deleteAuthority));
            user.setAuthorities(List.of(readAuthority, writeAuthority, updateAuthority));
            admin.setAuthorities(List.of(readAuthority, writeAuthority, updateAuthority, deleteAuthority));

            roleRepository.saveAll(List.of(student, instructor, user, admin));
        }

        // init users
        if(userRepository.count() < 10){
            List<Role> roles = roleRepository.findAll();
            int roleIndex = 0;
            for (int i = 0; i < 10; i++) {
                User user = new User();
                user.setUsername("username" + i);
                user.setPassword("password" + i);
                user.setEmail("email" + i + "@example.com");
                user.setGender(i % 2 == 0 ? "Male" : "Female");
                user.setGivenName("John" + i);
                user.setFamilyName("Doe" + i);
                user.setDob(LocalDate.of(1990 + i, 1, 1));
                user.setAddress1("Street 200" + i);
                user.setAddress2("PP" + i);
                user.setPhoneNumber("0123456789" + i);
                user.setNationalIdCard("0993456789" + i);
                user.setIsVerified(true);
                user.setVerifiedCode("verification_code" + i);
                user.setIsDeleted(false);
                user.setProfile("profile_data" + i);
                user.setUuid(UUID.randomUUID().toString());

                // set role for the user based on roleIndex
                user.setRoles(List.of(roles.get(roleIndex)));

                // increment roleIndex and reset to 0 if it exceeds the number of roles
                roleIndex = (roleIndex + 1) % roles.size();

                userRepository.save(user);
            }
        }
    }
}
