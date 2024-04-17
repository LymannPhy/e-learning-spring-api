package co.istad.elearningspringapi.features.role.dto;

import co.istad.elearningspringapi.features.authority.dto.AuthorityResponse;

import java.util.List;

public record RoleAuthorityResponse(
        String name,
        List<AuthorityResponse> authorities
) {
}