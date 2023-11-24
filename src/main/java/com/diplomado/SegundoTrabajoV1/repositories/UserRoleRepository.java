package com.diplomado.SegundoTrabajoV1.repositories;

import com.diplomado.SegundoTrabajoV1.domain.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    List<UserRole> findAllByUser_IdOrderById(Long userId);

    List<UserRole> findAllByRole_IdOrderById(Long roleId);

}
