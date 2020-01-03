package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/v1/user")
public class UserController {
    @RequestMapping(method = RequestMethod.GET, value = "getUsers")
    public List<UserDto> getUsers() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUser")
    public UserDto getUser(@RequestParam("userId") Long userId) {
        return new UserDto(1L, "user1", false, "58ef4c1bf245ac008e24127318386d1a6039787c31977b8ab1b2d7fe83c4c9ee");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteUser")
    public void deleteUser(@RequestParam Long userId) {
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateUser")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return new UserDto(1L, "user1a", false, "58ef4c1bf245ac008e24127318386d1a6039787c31977b8ab1b2d7fe83c4c9ee");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUser")
    public void createUse(UserDto userDto) {
    }
}
