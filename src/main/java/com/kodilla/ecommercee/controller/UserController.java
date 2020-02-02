package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.TokenNotFoundException;
import com.kodilla.ecommercee.domain.UserNotFoundException;
import com.kodilla.ecommercee.domain.dto.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.DbUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private DbUserService service;
    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "getUsers")
    public List<UserDto> getUsers() {
        return userMapper.mapToUserDtoList(service.getAllUsers());
    }

    @GetMapping(value = "getUser")
    public UserDto getUser(@RequestParam Long userId) throws UserNotFoundException {
        return userMapper.mapToUserDto(service.getUser(userId).orElseThrow(UserNotFoundException::new));
    }

    @DeleteMapping(value = "deleteUser")
    public void deleteUser(@RequestParam Long userId) {
        service.deleteUser(userId);
    }

    @PutMapping(value = "updateUser")
    public UserDto updateUser(@RequestBody UserDto userDto) throws UserNotFoundException {
        return userMapper.mapToUserDto(service.updateUser(userDto.getId(), userMapper.mapToUser(userDto)));
    }

    @PostMapping(value = "createUser")
    public void createUser(@RequestBody UserDto userDto) {
        service.saveUser(userMapper.mapToUser(userDto));
    }

    @PutMapping(value = "blockUser")
    private void blockUser(@RequestBody UserDto userDto) {
        service.blockUser(userMapper.mapToUser(userDto));
    }

    @GetMapping(value = "getToken")
    private void getToken(@RequestParam Long userId) throws TokenNotFoundException {
        service.generateToken(userId);
    }
}