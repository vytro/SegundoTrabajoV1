package com.diplomado.SegundoTrabajoV1.services.mapper;

import com.diplomado.SegundoTrabajoV1.domain.entities.User;
import com.diplomado.SegundoTrabajoV1.dto.UserDTO;

public class UserMapper {
    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setCreatedAt(user.getCreatedAt());
        return dto;
    }

    public static User fromDTO(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setCreatedAt(dto.getCreatedAt());
        return user;
    }

}
