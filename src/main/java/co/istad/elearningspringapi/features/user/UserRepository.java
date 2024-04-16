package co.istad.elearningspringapi.features.user;

import co.istad.elearningspringapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //Optional findByUsername();

    //@Query("SELECT u FROM User AS u WHERE u.username = :userName")
    Optional<User> findByUsername(String userName);

    Optional<User> findByUuid(String uuid);

}
