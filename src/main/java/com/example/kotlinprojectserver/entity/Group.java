package com.example.kotlinprojectserver.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "community_group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "headcount_limit", nullable = false)
    private Integer headcountLimit;

    @ManyToMany(mappedBy = "groups")
    private Set<Member> users;

    @Builder
    public Group(String groupName, String description, Integer headcountLimit) {
        this.name = groupName;
        this.description = description;
        this.headcountLimit = headcountLimit;
    }
}
