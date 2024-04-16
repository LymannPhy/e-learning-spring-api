package co.istad.elearningspringapi.features.role;

import co.istad.elearningspringapi.domain.Role;
import co.istad.elearningspringapi.features.role.dto.RoleAuthorityResponse;
import co.istad.elearningspringapi.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    }

    @Override
    public RoleAuthorityResponse findRoleByName(String name) {
        Role role = roleRepository.findByName(name)
                .orElseThrow(()->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Role has been not found...!"
                        ));
        return roleMapper.toRoleAuthorityResponse(role);
    }
}
