package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.GroupDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/group")
public class GroupController {

    @GetMapping(value = "getGroups")
    public List<GroupDto> getGroups() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getGroup")
    public GroupDto getGroup(@RequestParam Long groupId){
        return new GroupDto(groupId,"Some Group Name");
    }

    @DeleteMapping(value = "deleteGroup")
    public void deleteGroup(@RequestParam Long groupId) {
    }

    @PutMapping(value = "updateGroup")
    public GroupDto updateGroup(@RequestBody GroupDto GroupDto) {
        return new GroupDto(1L,"Updated Group Name");
    }

    @PostMapping(value = "createGroup")
    public void addGroup(@RequestBody GroupDto GroupDto) {
    }
}
