package co.istad.elearningspringapi.init;

import co.istad.elearningspringapi.domain.*;
import co.istad.elearningspringapi.features.authority.AuthorityRepository;
import co.istad.elearningspringapi.features.city.CityRepository;
import co.istad.elearningspringapi.features.country.CountryRepository;
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
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    private final UserRepository userRepository;

    @PostConstruct
    void init() {

        // authority init (if needed)
        if (authorityRepository.count() < 1) {
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
        if (roleRepository.count() < 1) {
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

        // init countries
        if (countryRepository.count() < 1) {
            Country usa = new Country();
            usa.setFlag("US_Flag");
            usa.setIso("US");
            usa.setName("United States");
            usa.setNiceName("USA");
            usa.setNumCode(840);
            usa.setPhoneCode("+1");

            Country canada = new Country();
            canada.setFlag("CA_Flag");
            canada.setIso("CA");
            canada.setName("Canada");
            canada.setNiceName("Canada");
            canada.setNumCode(124);
            canada.setPhoneCode("+1");

            Country cambodia = new Country();
            cambodia.setFlag("KH_Flag");
            cambodia.setIso("KH");
            cambodia.setName("Cambodia");
            cambodia.setNiceName("Kingdom of Cambodia");
            cambodia.setNumCode(116);
            cambodia.setPhoneCode("+855");

            countryRepository.saveAll(List.of(usa, canada, cambodia));
        }

        // init cities
        if (cityRepository.count() < 1) {
            Country usa = countryRepository.findByIso("US");
            Country canada = countryRepository.findByIso("CA");
            Country cambodia = countryRepository.findByIso("KH");

            City newYork = new City();
            newYork.setName("New York");
            newYork.setCountry(usa);

            City losAngeles = new City();
            losAngeles.setName("Los Angeles");
            losAngeles.setCountry(usa);

            City toronto = new City();
            toronto.setName("Toronto");
            toronto.setCountry(canada);

            City phnomPenh = new City();
            phnomPenh.setName("Phnom Penh");
            phnomPenh.setCountry(cambodia);

            cityRepository.saveAll(List.of(newYork, losAngeles, toronto, phnomPenh));
        }

        if (userRepository.count() < 10) {
            List<Role> roles = roleRepository.findAll();

            initializeUser("Sokny", "1234",
                    "psnpsn66@example.com", "Male",
                    "Jack", "Happy",
                    LocalDate.of(1991, 1, 1),
                    "Street 2002", "PP",
                    "01234567891", "09934567891",
                    "verification_code1",
                    "profile_data1", UUID.randomUUID().toString(),
                    roles.get(1));

            initializeUser("Mengseu", "5533",
                    "mengseu@example.com", "Male",
                    "seu seu", "seu seu",
                    LocalDate.of(1991, 1, 1),
                    "Wat Phnom", "Don Penh",
                    "01256232322", "0988877891",
                    "verification_code2",
                    "profile_data2", UUID.randomUUID().toString(),
                    roles.get(2));

            initializeUser("Lymann", "5566",
                    "lymann@example.com", "Male",
                    "mazer", "mann",
                    LocalDate.of(1991, 1, 1),
                    "PP", "BB",
                    "03356232322", "0998877891",
                    "verification_code2",
                    "profile_data3", UUID.randomUUID().toString(),
                    roles.get(2));

            initializeUser("Taingey", "1100",
                    "psn55@example.com", "Male",
                    "taingey", "handsome",
                    LocalDate.of(1991, 1, 1),
                    "PP", "TK",
                    "077336699", "07788877891",
                    "verification_code4",
                    "profile_data2", UUID.randomUUID().toString(),
                    roles.get(1));

            initializeUser("Vipha", "3333",
                    "psn77@example.com", "Female",
                    "seu seu", "seu seu",
                    LocalDate.of(1991, 1, 1),
                    "PP", "SS",
                    "0125628899", "0118877891",
                    "verification_code5",
                    "profile_data2", UUID.randomUUID().toString(),
                    roles.get(3));

            initializeUser("Thyda", "4444",
                    "thyda@example.com", "Female",
                    "seu seu", "seu seu",
                    LocalDate.of(1991, 1, 1),
                    "Wat Phnom", "SS",
                    "0175628899", "0158877891",
                    "verification_code6",
                    "profile_data2", UUID.randomUUID().toString(),
                    roles.get(3));

        }
    }

    private void initializeUser(String username, String password, String email, String gender,
                                String givenName, String familyName, LocalDate dob, String address1,
                                String address2, String phoneNumber, String nationalIdCard,
                                String verifiedCode,
                                String profile, String uuid, Role role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);
        user.setGivenName(givenName);
        user.setFamilyName(familyName);
        user.setDob(dob);
        user.setAddress1(address1);
        user.setAddress2(address2);
        user.setPhoneNumber(phoneNumber);
        user.setNationalIdCard(nationalIdCard);
        user.setIsVerified(true);
        user.setVerifiedCode(verifiedCode);
        user.setIsDeleted(false);
        user.setProfile(profile);
        user.setUuid(uuid);
        user.setRoles(List.of(role));

        userRepository.save(user);
    }
}
