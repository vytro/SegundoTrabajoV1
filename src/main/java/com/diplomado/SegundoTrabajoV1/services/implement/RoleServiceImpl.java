package com.diplomado.SegundoTrabajoV1.services.implement;

import com.diplomado.SegundoTrabajoV1.domain.entities.Role;
import com.diplomado.SegundoTrabajoV1.domain.entities.UserRole;
import com.diplomado.SegundoTrabajoV1.repositories.RoleRepository;
import com.diplomado.SegundoTrabajoV1.repositories.UserRoleRepository;
import com.diplomado.SegundoTrabajoV1.services.RoleService;
import com.diplomado.SegundoTrabajoV1.web.rest.exceptions.UserIdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    private final UserRoleRepository userRoleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, UserRoleRepository userRoleRepository) {
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role updateRole(Long id, Role roleDetails) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new UserIdNotFoundException(id));
        role.setName(roleDetails.getName());
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public List<UserRole> getUsersWithRole(Long roleId) {
        return userRoleRepository.findAllByRole_IdOrderById(roleId);
    }

    @Override
    public List<UserRole> getAllUserRoles() {
        return userRoleRepository.findAll();
    }
}