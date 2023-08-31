package com.example.kotlinprojectserver.dto;

import com.example.kotlinprojectserver.entity.Member;
import lombok.Getter;

@Getter
public class MemberResponse {
    private final Long memberId;
    private final String name;
    private final String id;
    private final String password;
    private final String email;

    public MemberResponse(Member member) {
        this.memberId = getMemberId();
        this.name = member.getName();
        this.id = member.getId();
        this.password = member.getPassword();
        this.email = member.getEmail();
    }
}
