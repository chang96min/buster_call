package com.levelUp.gisFood.user.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String addr;
    private String age;
    private String email;
    private String gender;
    private String name;
    private String password;
    private String phone;
    private String job;
}
