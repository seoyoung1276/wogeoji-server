package com.example.kotlinprojectserver.dto;

import com.example.kotlinprojectserver.entity.Group;
import lombok.Getter;

@Getter
public class GroupResponse {
    private final Long groupId;
    private final String name;
    private final String description;
    private final Integer headcountLimit;

    public GroupResponse(Group group) {
        this.groupId = group.getGroupId();
        this.name = group.getName();
        this.description = group.getDescription();
        this.headcountLimit = group.getHeadcountLimit();
    }
}
