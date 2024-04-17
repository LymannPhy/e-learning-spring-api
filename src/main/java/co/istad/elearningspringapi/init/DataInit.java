package co.istad.elearningspringapi.init;


import co.istad.elearningspringapi.domain.Authority;
import co.istad.elearningspringapi.domain.Role;
import co.istad.elearningspringapi.features.authority.AuthorityRepository;
import co.istad.elearningspringapi.features.role.RoleRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInit {

    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;

    @PostConstruct
    void init(){

        // authority init (if needed)
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

    }

}
