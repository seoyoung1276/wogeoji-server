package com.example.kotlinprojectserver.controller;

import com.example.kotlinprojectserver.entity.Member;
import com.example.kotlinprojectserver.repository.MemberRepository;
import com.example.kotlinprojectserver.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final MemberRepository memberRepository;

    @Autowired
    public AuthController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<Member> login(@RequestBody LoginRequest loginRequest) {
        Optional<Member> member = memberRepository.findByMemberIdAndPassword(loginRequest.getMemberId(), loginRequest.getPassword());

        if (member.isPresent()) {
            System.out.println(1);
            System.out.println(member.get());
            return ResponseEntity.status(HttpStatus.OK).body(member.get());
        } else {
            System.out.println(0);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
