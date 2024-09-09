package com.levelUp.gisFood.user.repository;

import com.levelUp.gisFood.user.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
