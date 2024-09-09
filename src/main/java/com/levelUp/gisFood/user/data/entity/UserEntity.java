package com.levelUp.gisFood.user.data.entity;

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
    private Long id;

    private String password;

    private String name;

    private String email;

    private String phone;

    private int age;

    private char gender;

}
