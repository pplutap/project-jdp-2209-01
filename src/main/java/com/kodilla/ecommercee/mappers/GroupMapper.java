package com.kodilla.ecommercee.mappers;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDto;

public class GroupMapper {

    public static GroupDto mapToDto(Group group){
        return new GroupDto(group.getId(), group.getName());
    }


}
