package com.levelUp.busterCall.user.data.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long userId;
    private String addr;
    private String age;
    private String email;
    private String gender;
    private String name;
    private String password;
    private String phone;
    private String job;
}
