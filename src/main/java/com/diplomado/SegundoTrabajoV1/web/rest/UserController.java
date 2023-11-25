package com.diplomado.SegundoTrabajoV1.web.rest;

import com.diplomado.SegundoTrabajoV1.domain.entities.User;
import com.diplomado.SegundoTrabajoV1.domain.entities.UserDetail;
import com.diplomado.SegundoTrabajoV1.dto.UserDetailDTO;
import com.diplomado.SegundoTrabajoV1.repositories.UserRepository;
import com.diplomado.SegundoTrabajoV1.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
//        return ResponseEntity.ok(userService.createUser(user));

//        UserDetail userDetail = new UserDetail();
//        user.setUserDetail(userDetail);
//        userDetail.setUser(user);
//        userRepository.save(user);
//        return ResponseEntity.ok(user);

//        UserDetail userDetail = new UserDetail();
//        userDetail.setFirstName("");
//        userDetail.setLastName("");
//        user.setUserDetail(userDetail);
//        user.setCreatedAt(LocalDateTime.now());
//        userRepository.save(user);
//        return ResponseEntity.ok(user);

        UserDetail userDetail = user.getUserDetail();

        if (userDetail == null) {
            userDetail = new UserDetail();
            userDetail.setFirstName("");
            userDetail.setLastName("");
        }

        user.setUserDetail(userDetail);
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/detailedUsers")
    public ResponseEntity<List<UserDetailDTO>> getAllDetailedUsers() {
        List<User> users = userService.getAllUsers();

        List<UserDetailDTO> detailedUsers = users.stream()
                .map(user -> {
                    UserDetail userDetail = user.getUserDetail();
                    UserDetailDTO dto = new UserDetailDTO();
                    dto.setId(user.getId());
                    dto.setUsername(user.getUsername());
                    dto.setEmail(user.getEmail());
                    dto.setCreatedAt(user.getCreatedAt());
                    if (userDetail != null) {
                        dto.setFirstName(userDetail.getFirstName());
                        dto.setLastName(userDetail.getLastName());
                        dto.setAge(userDetail.getAge());
                        dto.setBirthDay(userDetail.getBirthDay());
                    }
                    return dto;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(detailedUsers);
    }
}
