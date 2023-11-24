package com.diplomado.SegundoTrabajoV1.services;

import com.diplomado.SegundoTrabajoV1.domain.entities.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Role createRole(Role role);
    Optional<Role> getRoleById(Long id);
    List<Role> getAllRoles();
    Role updateRole(Long id, Role role);
    void deleteRole(Long id);
}