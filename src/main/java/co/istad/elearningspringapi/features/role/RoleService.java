package co.istad.elearningspringapi.features.role;

import co.istad.elearningspringapi.features.role.dto.RoleAuthorityResponse;

import java.util.List;

public interface RoleService {

    List<RoleAuthorityResponse> findRoles();

    RoleAuthorityResponse findRoleByName(String name);

}