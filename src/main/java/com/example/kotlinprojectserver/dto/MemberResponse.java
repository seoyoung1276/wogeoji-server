package com.example.kotlinprojectserver.dto;

import com.example.kotlinprojectserver.entity.Member;
import lombok.Getter;

@Getter
public class MemberResponse {
    private final Long memberNo;
    private final String name;
    private final String memberId;
    private final String password;
    private final String email;

    public MemberResponse(Member member) {
        this.memberNo = getMemberNo();
        this.name = member.getName();
        this.memberId = member.getMemberId();
        this.password = member.getPassword();
        this.email = member.getEmail();
    }
}
