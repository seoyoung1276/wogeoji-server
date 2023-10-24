package com.example.kotlinprojectserver.dto;

import com.example.kotlinprojectserver.entity.Group;
import lombok.Getter;

@Getter
public class GroupResponse {
    private final Long groupNo;
    private final String name;
    private final String description;
    private final Integer headcountLimit;

    public GroupResponse(Group group) {
        this.groupNo = group.getGroupNo();
        this.name = group.getName();
        this.description = group.getDescription();
        this.headcountLimit = group.getHeadcountLimit();
    }
}
