package co.istad.elearningspringapi.feature.student.dto;

import co.istad.elearningspringapi.feature.user.dto.UserResponse;

public record StudentResponse(
        Long id,
        String highSchool,
        Boolean isBlocked,
        String university,
        UserResponse user
) {
}
