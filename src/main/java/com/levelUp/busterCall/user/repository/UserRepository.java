package com.levelUp.busterCall.user.repository;

import com.levelUp.busterCall.user.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
