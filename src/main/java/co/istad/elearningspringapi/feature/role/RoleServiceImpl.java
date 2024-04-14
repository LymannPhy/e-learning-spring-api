package co.istad.elearningspringapi.feature.role;

import co.istad.elearningspringapi.domain.Role;
import co.istad.elearningspringapi.feature.role.RoleService;
import co.istad.elearningspringapi.feature.role.dto.RoleAuthorityResponse;
import co.istad.elearningspringapi.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public List<RoleAuthorityResponse> findRoles() {
        List<Role> roleList = roleRepository.findAll();
        return roleMapper.toRoleAuthorityResponseList(roleList);
        //return roleList.stream().map(roleMapper::toRoleAuthorityResponse);
    }
}
