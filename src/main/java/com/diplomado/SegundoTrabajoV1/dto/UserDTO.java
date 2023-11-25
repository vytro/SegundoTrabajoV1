package com.diplomado.SegundoTrabajoV1.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private LocalDateTime createdAt;

    public UserDTO() {
    }


}