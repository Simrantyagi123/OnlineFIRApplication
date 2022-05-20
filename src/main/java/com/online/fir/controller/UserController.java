package com.online.fir.controller;

import com.online.fir.constant.Constants;
import com.online.fir.mapper.UserMapper;
import com.online.fir.model.dto.UserDto;
import com.online.fir.model.entity.User;
import com.online.fir.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.BASE_URL)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Slf4j
public class UserController {

    UserService userService;

    @PostMapping(Constants.USER)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto signUp(@RequestBody UserDto userDto) {
        log.info("Inside UserController : signUp");
        User user = UserMapper.toEntity(userDto);
        return UserMapper.toApi(userService.signUp(user));
    }

    @PostMapping(Constants.LOGIN)
    @ResponseStatus(HttpStatus.OK)
    public UserDto login(@RequestBody UserDto userDto){
        log.info("Inside UserController : login");
        User user = UserMapper.toEntity(userDto);
        return UserMapper.toApi(userService.login(user));
    }
}
