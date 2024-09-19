package com.levelUp.gisFood.user.data.entity;

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
    @Column
    private Long id;
    @Column
    private String addr;
    @Column
    private String age;
    @Column
    private String email;
    @Column
    private String gender;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private String phone;
    @Column
    private String job;

}
