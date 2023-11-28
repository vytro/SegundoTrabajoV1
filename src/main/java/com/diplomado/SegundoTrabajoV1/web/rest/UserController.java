package com.diplomado.SegundoTrabajoV1.web.rest;

import com.diplomado.SegundoTrabajoV1.domain.entities.User;
import com.diplomado.SegundoTrabajoV1.domain.entities.UserDetail;
import com.diplomado.SegundoTrabajoV1.dto.UserDetailDTO;
import com.diplomado.SegundoTrabajoV1.repositories.UserRepository;
import com.diplomado.SegundoTrabajoV1.services.UserService;
import org.springframework.http.HttpStatus;
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
        System.out.println("Received user: " + user);

        UserDetail userDetail = user.getUserDetail();

        if (userDetail == null) {
            userDetail = new UserDetail();
            userDetail.setFirstName("");
            userDetail.setLastName("");
        } else {
        userDetail.setUser(user);
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
        try{
            if (userService.updateUser(id,user) != null) {
                return ResponseEntity.ok(userService.updateUser(id, user));
            } else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

//        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        try{
            userService.deleteUser(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return new ResponseEntity<>(null, null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
