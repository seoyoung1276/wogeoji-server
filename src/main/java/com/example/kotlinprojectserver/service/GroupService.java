package com.example.kotlinprojectserver.service;

import com.example.kotlinprojectserver.entity.Group;
import com.example.kotlinprojectserver.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository){
        this.groupRepository = groupRepository;
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group getGroupById(Long groupId) {
        return groupRepository.findById(groupId).orElse(null);
    }

    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    public Group updateGroup(Long groupId, Group updateGroup) {
        if (groupRepository.existsById(groupId)) {
            updateGroup.setGroupId(groupId);
            return groupRepository.save(updateGroup);
        } else {
            throw new RuntimeException("Group not found with ID: " + groupId);
        }
    }

    public void deleteGroup(Long groupId) {
        groupRepository.deleteById(groupId);
    }
}
