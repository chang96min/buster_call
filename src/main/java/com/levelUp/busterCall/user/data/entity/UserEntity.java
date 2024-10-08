package com.levelUp.busterCall.user.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {

    @Id
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
