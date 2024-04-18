package co.istad.elearningspringapi.features.user;

import co.istad.elearningspringapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String userName);

    Optional<User> findByUuid(String uuid);

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
    Optional<List<User>> findByEmailContaining(String email);

    @Modifying
    @Query("""
    SELECT u FROM User u
    where u.nationalIdCard LIKE %:nationalIdCard%
    """)
    Optional<List<User>> findByNationalIdCardContaining(String nationalIdCard);

    @Modifying
    @Query("""
    SELECT u FROM User u
    where u.phoneNumber LIKE %:phoneNumber%
    """)
    Optional<List<User>> findByPhoneNumberContaining(String phoneNumber);

    @Modifying
    @Query("""
    SELECT u FROM User u
    WHERE LOWER(u.gender) = LOWER(:gender)
    OR UPPER(u.gender) = UPPER(:gender)
    OR INITCAP(u.gender) = INITCAP(:gender)
    """)
    Optional<List<User>> findByGenderContainingIgnoreCase(String gender);


    @Modifying
    @Query("""
    SELECT u FROM User u
    where u.givenName LIKE %:givenName%
    """)
    Optional<List<User>> findByGivenName(String givenName);

    @Modifying
    @Query("""
    SELECT u FROM User u
    where u.familyName LIKE %:familyName%
    """)
    Optional<List<User>> findByFamilyName(String familyName);

    @Modifying
    @Query("""
    SELECT u FROM User u 
    JOIN u.roles r
    WHERE LOWER(r.name) LIKE LOWER(CONCAT('%', :roleName, '%'))
    """)
    Optional<List<User>> findByRolesContainingIgnoreCase(String roleName);

}