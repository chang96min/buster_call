package com.levelUp.busterCall.user.data.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
