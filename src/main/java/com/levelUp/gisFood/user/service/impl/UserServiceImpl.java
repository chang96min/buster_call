package com.levelUp.gisFood.user.service.impl;

import com.levelUp.gisFood.user.data.entity.UserDto;
import com.levelUp.gisFood.user.data.entity.UserEntity;
import com.levelUp.gisFood.user.repository.UserRepository;
import com.levelUp.gisFood.user.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserDto getUserEntity(Long id){
        UserEntity userEntity = userRepository.getReferenceById(id);

        UserDto userDto = UserDto.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .phone(userEntity.getPhone())
                .age(userEntity.getAge())
                .build();

        System.out.println(userDto);

        return userDto;
    }
}
