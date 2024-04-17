package co.istad.elearningspringapi.features.instructor.dto;

import co.istad.elearningspringapi.features.user.dto.UserSnippingResponse;

public record InstructorSnippingResponse(
        Long id,
        String biography,
        String github,
        String isBlocked,
        String jobTitle,
        String linkedIn,
        String website,
        UserSnippingResponse user
) {
}
