package com.levelUp.gisFood.user.data.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String password;

    private String name;

    private String email;

    private String phone;

    private int age;

    private String gender;
}
