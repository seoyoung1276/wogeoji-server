package com.example.kotlinprojectserver.controller;

import com.example.kotlinprojectserver.dto.GroupResponse;
import com.example.kotlinprojectserver.dto.MemberResponse;
import com.example.kotlinprojectserver.entity.Group;
import com.example.kotlinprojectserver.entity.Member;
import com.example.kotlinprojectserver.request.GroupRequest;
import com.example.kotlinprojectserver.service.GroupService;
import com.example.kotlinprojectserver.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;
    private final MemberService memberService;

    @Autowired
    public GroupController(GroupService groupService, MemberService memberService) {
        this.groupService = groupService;
        this.memberService = memberService;
    }

    @GetMapping("/")
    public ResponseEntity<List<GroupResponse>> getAllGroups() {
        List<GroupResponse> groups= groupService.getAllGroups()
                .stream()
                .map(GroupResponse::new)
                .toList();
        return ResponseEntity.ok().body(groups);
    }


    @GetMapping("/{groupId}")
    public Group getGroupById(@PathVariable Long id) {
        return groupService.getGroupById(id);
    }

    @PostMapping("/group")
    public ResponseEntity<Group> createMember(@RequestBody GroupRequest group) {
        Group savedGroup = groupService.createGroup(new Group(group.getName(), group.getDescription(), group.getHeadcountLimit()));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGroup);
    }
    @PutMapping("/{groupID}")
    public void deleteGroup(@PathVariable Long groupID) {
        groupService.deleteGroup(groupID);
    }

    @PostMapping("/{groupId}/join")
    public ResponseEntity<String> joinGroup(
            @PathVariable Long groupId,
            @RequestParam Long memberId
    ) {
        Group group = groupService.getGroupById(groupId);
        Member member = memberService.getMemberById(memberId);

        if (group != null && member != null) {
            if (!group.getUsers().contains(member)) {
                group.getUsers().add(member); // Add the member to the group
                groupService.saveGroup(group);

                if (!member.getGroups().contains(group)) {
                    member.getGroups().add(group);
                    memberService.saveMember(member);
                }

                return ResponseEntity.ok("Member has joined the group.");
            } else {
                return ResponseEntity.badRequest().body("Member is already part of the group.");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
