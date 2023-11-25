package com.diplomado.SegundoTrabajoV1.services;

import com.diplomado.SegundoTrabajoV1.domain.entities.UserRole;
import java.util.List;

public interface UserRoleService {

    UserRole createUserRole(UserRole userRole);

//    UserRole createUserRole(Long userId, Long roleId, UserRole userRole);

    List<UserRole> getUserRolesByUserId(Long userId);

//    List<UserRole> getUserRolesByRoleId(Long roleId);
    UserRole updateUserRole(UserRole userRole);
    void deleteUserRole(Long id);
}
