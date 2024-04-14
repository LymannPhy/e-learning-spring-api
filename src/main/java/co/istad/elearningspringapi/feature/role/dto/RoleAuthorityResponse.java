package co.istad.elearningspringapi.feature.role.dto;

import co.istad.elearningspringapi.domain.Authority;

import java.util.List;

public record RoleAuthorityResponse(
        String name,
        List<Authority> authorities
) {
}
