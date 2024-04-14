package co.istad.elearningspringapi.mapper;


import co.istad.elearningspringapi.domain.Role;
import co.istad.elearningspringapi.feature.role.dto.RoleAuthorityResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleAuthorityResponse toRoleAuthorityResponse(Role role);

    List<RoleAuthorityResponse> toRoleAuthorityResponseList(List<Role> roleList);
}
