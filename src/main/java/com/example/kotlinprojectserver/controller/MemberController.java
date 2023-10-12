package com.example.kotlinprojectserver.controller;
import com.example.kotlinprojectserver.dto.MemberResponse;
import com.example.kotlinprojectserver.entity.Group;
import com.example.kotlinprojectserver.entity.Member;
import com.example.kotlinprojectserver.service.GroupService;
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
    private final GroupService groupService;

    @Autowired
    public MemberController(MemberService memberService, GroupService groupService) {
        this.memberService = memberService;
        this.groupService = groupService;
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
    public ResponseEntity<MemberResponse> getMemberById(@PathVariable Long memberId) {
        Member member = memberService.getMemberById(memberId);
        if (member != null) {
            MemberResponse memberResponse = new MemberResponse(member);
            return ResponseEntity.ok().body(memberResponse);
        }
        return ResponseEntity.notFound().build();
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

    @PostMapping("/{memberId}/join/{groupId}")
    public ResponseEntity<String> joinGroup(
            @PathVariable Long memberId,
            @PathVariable Long groupId
    ) {
        Member member = memberService.getMemberById(memberId);
        Group group = groupService.getGroupById(groupId);

        if (member != null && group != null) {
            // Associate the member with the group
            member.getGroups().add(group);
            memberService.saveMember(member);
            return ResponseEntity.ok("Member has joined the group.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
