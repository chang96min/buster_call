package com.levelUp.busterCall.user.service.impl;

import com.levelUp.busterCall.user.data.dto.UserDto;
import com.levelUp.busterCall.user.data.entity.UserEntity;
import com.levelUp.busterCall.user.repository.UserRepository;
import com.levelUp.busterCall.user.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto getUserEntity(Long id){
        UserEntity userEntity = userRepository.getReferenceById(id);

        UserDto userDto = UserDto.builder()
                .userId(userEntity.getUserId())
                .addr(userEntity.getAddr())
                .age(userEntity.getAge())
                .email(userEntity.getEmail())
                .gender(userEntity.getGender())
                .name(userEntity.getName())
                .password(userEntity.getPassword())
                .phone(userEntity.getPhone())
                .job(userEntity.getJob())
                .build();

        System.out.println(userDto);

        return userDto;
    }

    @Override
    public UserDto regUser(UserDto userDto) {
        //DTO -> Entity
        UserEntity userEntity = UserEntity.builder()
                .age(userDto.getAge())
                .job(userDto.getJob())
                .name(userDto.getName())
                .phone(userDto.getPhone())
                .addr(userDto.getAddr())
                .email(userDto.getEmail())
                .gender(userDto.getGender())
                .password(userDto.getPassword())
                .build();
        //INSERT
        UserEntity returnUserEntity = userRepository.save(userEntity);

        //Entity -> DTO
        UserDto returnUserDto = UserDto.builder()
                .userId(returnUserEntity.getUserId())
                .age(returnUserEntity.getAge())
                .name(returnUserEntity.getName())
                .job(returnUserEntity.getJob())
                .addr(returnUserEntity.getAddr())
                .email(returnUserEntity.getEmail())
                .gender(returnUserEntity.getGender())
                .phone(returnUserEntity.getPhone())
                .password(returnUserEntity.getPassword())
                .build();

        return returnUserDto;
    }
}
