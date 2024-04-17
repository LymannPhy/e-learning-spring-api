package co.istad.elearningspringapi.features.user;

import co.istad.elearningspringapi.domain.Role;
import co.istad.elearningspringapi.domain.User;
import co.istad.elearningspringapi.features.user.dto.UserDetailsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //Optional findByUsername();

    //@Query("SELECT u FROM User AS u WHERE u.username = :userName")
    Optional<User> findByUsername(String userName);

    Optional<User> findByUuid(String uuid);

    Optional<User> findByEmail(String email);

    @Modifying
    @Query("""
    SELECT u FROM User u
    WHERE u.username LIKE %:userName%
    """)
    Optional<List<User>> findByUsernameContaining(String userName);

    @Modifying
    @Query("""
    SELECT u FROM User u
    where u.email LIKE %:email%
    """)
    List<User> findByEmailContaining(String email);

    @Modifying
    @Query("""
    SELECT u FROM User u
    where u.nationalIdCard LIKE %:nationalIdCard%
    """)
    List<User> findByNationalIdCardContaining(String nationalIdCard);

    @Modifying
    @Query("""
    SELECT u FROM User u
    where u.phoneNumber LIKE %:phoneNumber%
    """)
    List<User> findByPhoneNumberContaining(String phoneNumber);

    @Modifying
    @Query("""
    SELECT u FROM User u
    where u.gender LIKE %:gender%
    """)
    List<User> findByGenderContaining(String gender);


    //List<User> findByRolesContaining(List<Role> roles);

}
