package com.levelUp.gisFood.user.controller;

import com.levelUp.gisFood.user.data.entity.UserDto;
import com.levelUp.gisFood.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/gisFood/user")
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/getUser/{id}")
    public void getUser(@PathVariable Long id){
        UserDto userDto = userService.getUserEntity(id);
        System.out.println(userDto.getId());
        System.out.println(userDto.getName());
        System.out.println(userDto.getEmail());

    }
}
