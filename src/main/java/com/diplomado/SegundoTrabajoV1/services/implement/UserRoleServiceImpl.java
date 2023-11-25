package com.diplomado.SegundoTrabajoV1.services.implement;

import com.diplomado.SegundoTrabajoV1.domain.entities.Role;
import com.diplomado.SegundoTrabajoV1.domain.entities.User;
import com.diplomado.SegundoTrabajoV1.domain.entities.UserRole;
import com.diplomado.SegundoTrabajoV1.repositories.RoleRepository;
import com.diplomado.SegundoTrabajoV1.repositories.UserRepository;
import com.diplomado.SegundoTrabajoV1.repositories.UserRoleRepository;
import com.diplomado.SegundoTrabajoV1.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository, UserRepository userRepository, RoleRepository roleRepository) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }



//    @Override
//    public UserRole createUserRole(UserRole userRole) {
//        //    @Override
////    public UserRole createUserRole(UserRole userRole) {
////        return userRoleRepository.save(userRole);
////    }
//        return null;
//    }

    @Override
    public UserRole createUserRole(UserRole userRole) {

        userRole.setCreatedAt(LocalDateTime.now());
//        userRole.setActive(true);

        return userRoleRepository.save(userRole);
    }

    @Override
    public List<UserRole> getUserRolesByUserId(Long userId) {
        return userRoleRepository.findAllByUser_IdOrderById(userId);
    }

    @Override
    public UserRole updateUserRole(UserRole userRole) {

        userRole.setActive(userRole.getActive());
        userRole.setUser(userRole.getUser());
        userRole.setRole(userRole.getRole());
        return userRoleRepository.save(userRole);
    }

    @Override
    public void deleteUserRole(Long id) {
        userRoleRepository.deleteById(id);
    }

}
