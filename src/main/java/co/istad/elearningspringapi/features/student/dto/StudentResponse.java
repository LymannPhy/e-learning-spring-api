package co.istad.elearningspringapi.features.student.dto;

import co.istad.elearningspringapi.features.user.dto.UserResponse;

public record StudentResponse(
        Long id,
        String highSchool,
        Boolean isBlocked,
        String university,
        UserResponse user
) {
}
