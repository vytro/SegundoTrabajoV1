package com.diplomado.SegundoTrabajoV1.repositories;

import com.diplomado.SegundoTrabajoV1.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
