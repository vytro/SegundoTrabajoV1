package com.diplomado.SegundoTrabajoV1.repositories;

import com.diplomado.SegundoTrabajoV1.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
