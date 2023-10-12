package com.example.kotlinprojectserver.dto;

import com.example.kotlinprojectserver.entity.Group;
import com.example.kotlinprojectserver.entity.Member;
import lombok.Getter;

import java.util.Set;

@Getter
public class MemberResponse {
    private final Long memberNo;
    private final String name;
    private final String memberId;
    private final String password;
    private final String email;
    private final Set<Group> groups;

    public MemberResponse(Member member) {
        this.memberNo = member.getMemberNo();
        this.name = member.getName();
        this.memberId = member.getMemberId();
        this.password = member.getPassword();
        this.email = member.getEmail();
        this.groups = member.getGroups();
    }
}
