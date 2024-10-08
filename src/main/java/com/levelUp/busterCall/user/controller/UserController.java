package com.levelUp.busterCall.user.controller;

import com.levelUp.busterCall.user.data.dto.UserDto;
import com.levelUp.busterCall.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/getUser/{id}")
    public UserDto getUser(@PathVariable Long id){
        UserDto userDto = userService.getUserEntity(id);
        return userDto;
    }
}
