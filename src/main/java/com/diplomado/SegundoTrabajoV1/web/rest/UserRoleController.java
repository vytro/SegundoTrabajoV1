package com.diplomado.SegundoTrabajoV1.web.rest;

import com.diplomado.SegundoTrabajoV1.domain.entities.UserRole;
import com.diplomado.SegundoTrabajoV1.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/roles")
public class UserRoleController {

    private final UserRoleService userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @GetMapping
    public ResponseEntity<List<UserRole>> listUserRolesByUser(@PathVariable Long userId) {
        return ResponseEntity.ok().body(userRoleService.getUserRolesByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<UserRole> createUserRole(@RequestBody UserRole userRole) throws URISyntaxException {
        if (userRole.getId() != null) {
            throw new IllegalArgumentException("A new user role cannot already have an id.");
        }
        userRole.setCreatedAt(LocalDateTime.now());

        UserRole savedUserRole = userRoleService.createUserRole(userRole);

        return ResponseEntity
                .created(new URI("/api/users/" + savedUserRole.getUser().getId() + "/roles/" + savedUserRole.getId()))
                .body(savedUserRole);
    }

//    @GetMapping("/role/{roleId}")
//    public ResponseEntity<List<UserRole>> getUserRolesByRoleId(@PathVariable Long roleId) {
//        return ResponseEntity.ok(userRoleService.getUserRolesByRoleId(roleId));
//    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRole> updateUserRole(@RequestBody UserRole userRole) {
        return ResponseEntity.ok(userRoleService.updateUserRole(userRole));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserRole(@PathVariable Long id) {
        userRoleService.deleteUserRole(id);
        return ResponseEntity.ok().build();
    }
}
