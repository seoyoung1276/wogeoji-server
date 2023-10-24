package com.example.kotlinprojectserver.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupRequest {
    private String name;
    private String description;
    private Integer headcountLimit;
}

