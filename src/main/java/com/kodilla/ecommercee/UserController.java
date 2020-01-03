package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/v1/user")
public class UserController {
    @GetMapping(value = "getUsers")
    public List<UserDto> getUsers() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getUser")
    public UserDto getUser(@RequestParam("userId") Long userId) {
        return new UserDto(1L, "user1", false, "58ef4c1bf245ac008e24127318386d1a6039787c31977b8ab1b2d7fe83c4c9ee");
    }

    @DeleteMapping(value = "deleteUser")
    public void deleteUser(@RequestParam Long userId) {
    }

    @PutMapping(value = "updateUser")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return new UserDto(1L, "user1a", false, "58ef4c1bf245ac008e24127318386d1a6039787c31977b8ab1b2d7fe83c4c9ee");
    }

    @PostMapping(value = "createUser")
    public void createUse(UserDto userDto) {
    }

    @PutMapping(value = "blockUser")
    private UserDto blockUser(@RequestParam Long userId) {
        return new UserDto(1L, "user1", true, "58ef4c1bf245ac008e24127318386d1a6039787c31977b8ab1b2d7fe83c4c9ee");
    }

    @GetMapping(value = "getToken")
    private String getToken(@RequestParam Long userId) {
        return "58ef4c1bf245ac008e24127318386d1a6039787c31977b8ab1b2d7fe83c4c9ee";
    }
}
