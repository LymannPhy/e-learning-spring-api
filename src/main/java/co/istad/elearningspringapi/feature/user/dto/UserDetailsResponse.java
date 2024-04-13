package co.istad.elearningspringapi.feature.user.dto;

import co.istad.elearningspringapi.domain.*;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

public record UserDetailsResponse(
        String username,

        String password,

        String email,

        City city,

        Country country,

        String givenName,

        String familyName,

        LocalDate dob,

        String gender,

        String address1,

        String address2,


        String phoneNumber,

        Boolean isVerified,

        String verifiedCode,

        Boolean isDeleted,

        String nationalIdCard,

        String profile,

        Instructor instructor,

        Student student,

        String uuid,

        List<Role> roles
) {

}
