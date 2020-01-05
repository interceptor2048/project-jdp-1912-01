package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDto;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper {
    public Group mapToGroup(GroupDto groupDto) {
        return new Group(groupDto.getGroupName());
    }

    public GroupDto mapToGroupDto(Group group) {
        return new GroupDto(group.getId(), group.getGroupName());
    }
}
