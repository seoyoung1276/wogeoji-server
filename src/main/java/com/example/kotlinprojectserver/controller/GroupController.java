package com.example.kotlinprojectserver.controller;

import com.example.kotlinprojectserver.dto.GroupResponse;
import com.example.kotlinprojectserver.dto.MemberResponse;
import com.example.kotlinprojectserver.entity.Group;
import com.example.kotlinprojectserver.entity.Member;
import com.example.kotlinprojectserver.service.GroupService;
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

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
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
    public Optional<Group> getGroupById(@PathVariable Long id) {
        return groupService.getGroupById(id);
    }

    @PostMapping("/group")
    public ResponseEntity<Group> createMember(@RequestBody Group group) {
        Group savedGroup = groupService.createGroup(group);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGroup);
    }
    @PutMapping("/{groupID}")
    public void deleteGroup(@PathVariable Long groupID) {
        groupService.deleteGroup(groupID);
    }
}
