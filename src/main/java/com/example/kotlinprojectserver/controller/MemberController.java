package com.example.kotlinprojectserver.controller;
import com.example.kotlinprojectserver.dto.MemberResponse;
import com.example.kotlinprojectserver.entity.Member;
import com.example.kotlinprojectserver.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public ResponseEntity<List<MemberResponse>> getAllMembers() {
        List<MemberResponse> members = memberService.getAllMembers()
                .stream()
                .map(MemberResponse::new)
                .toList();
        return ResponseEntity.ok().body(members);
    }

    @GetMapping("/{memberId}")
    public Optional<Member> getMemberById(@PathVariable Long memberId) {
        return memberService.getMemberById(memberId);
    }

    @PostMapping("/member")
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        Member savedMember = memberService.createMember(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMember);
    }

    @PutMapping("/{memberId}")
    public Member updateMember(@PathVariable Long memberId, @RequestBody Member updatedMember) {
        return memberService.updateMember(memberId, updatedMember);
    }

    @DeleteMapping("/{memberId}")
    public void deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
    }
}
