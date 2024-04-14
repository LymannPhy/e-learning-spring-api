package co.istad.elearningspringapi.feature.role;

import co.istad.elearningspringapi.feature.role.dto.RoleAuthorityResponse;

import java.util.List;

public interface RoleService {

    List<RoleAuthorityResponse> findRoles();
}
