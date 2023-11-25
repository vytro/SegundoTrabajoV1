package com.diplomado.SegundoTrabajoV1.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserDetailDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate birthDay;

    private String username;
    private String email;
    private LocalDateTime createdAt;

    public UserDetailDTO() {
    }
}
