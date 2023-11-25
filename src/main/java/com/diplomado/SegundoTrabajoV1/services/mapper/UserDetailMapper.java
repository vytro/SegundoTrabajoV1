package com.diplomado.SegundoTrabajoV1.services.mapper;

import com.diplomado.SegundoTrabajoV1.domain.entities.UserDetail;
import com.diplomado.SegundoTrabajoV1.dto.UserDetailDTO;

public class UserDetailMapper {
    public static UserDetailDTO toDTO(UserDetail userDetail) {
        UserDetailDTO dto = new UserDetailDTO();
        dto.setId(userDetail.getId());
        dto.setFirstName(userDetail.getFirstName());
        dto.setLastName(userDetail.getLastName());
        dto.setAge(userDetail.getAge());
        dto.setBirthDay(userDetail.getBirthDay());
        return dto;
    }

    public static UserDetail fromDTO(UserDetailDTO dto) {
        UserDetail userDetail = new UserDetail();
        userDetail.setId(dto.getId());
        userDetail.setFirstName(dto.getFirstName());
        userDetail.setLastName(dto.getLastName());
        userDetail.setAge(dto.getAge());
        userDetail.setBirthDay(dto.getBirthDay());
        return userDetail;
    }
}
