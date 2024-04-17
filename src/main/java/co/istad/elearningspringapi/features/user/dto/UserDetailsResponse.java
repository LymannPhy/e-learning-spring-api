package co.istad.elearningspringapi.features.user.dto;

import co.istad.elearningspringapi.domain.*;
import co.istad.elearningspringapi.features.role.dto.RoleResponse;

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

        String uuid,

        List<RoleResponse> roles
) {

}