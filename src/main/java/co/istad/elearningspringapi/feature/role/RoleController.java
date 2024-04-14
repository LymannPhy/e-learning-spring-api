package co.istad.elearningspringapi.feature.role;

import co.istad.elearningspringapi.feature.role.dto.RoleAuthorityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/roles/")
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    List<RoleAuthorityResponse> findRoles(){
        return roleService.findRoles();
    }

    @GetMapping("{name}")
    RoleAuthorityResponse findRoleByName(@PathVariable String name){
        return roleService.findRoleByName(name);
    }


}
