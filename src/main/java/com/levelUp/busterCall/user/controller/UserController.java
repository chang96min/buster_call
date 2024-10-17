package com.levelUp.busterCall.user.controller;

import com.levelUp.busterCall.user.data.dto.UserDto;
import com.levelUp.busterCall.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/regUser")
    public UserDto regUser(HttpServletRequest request, @RequestBody UserDto userDto) {
        UserDto returnValue = userService.regUser(userDto);

        return returnValue;
    }
}
