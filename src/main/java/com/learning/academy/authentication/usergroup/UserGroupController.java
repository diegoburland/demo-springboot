package com.learning.academy.authentication.usergroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-groups")
public class UserGroupController {

    @Autowired
    private UserGroupService userGroupService;

    @PostMapping
    public ResponseEntity<UserGroup> createUserGroup(@RequestBody UserGroup userGroup) {

        return ResponseEntity.ok(userGroupService.createUserGroup(userGroup));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserGroup> getUserGroupById(@PathVariable Long id) {
        return userGroupService.getUserGroupById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<UserGroup>> getAllUserGroups() {
        return ResponseEntity.ok(userGroupService.getAllUserGroups());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserGroup> updateUserGroup(@PathVariable Long id, @RequestBody UserGroup userGroup) {
        userGroupService.getUserGroupById(id).orElseThrow(() -> new RuntimeException("UserGroup not found"));
        userGroup.setId(id);
        return ResponseEntity.ok(userGroupService.updateUserGroup(userGroup));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserGroup(@PathVariable Long id) {
        userGroupService.deleteUserGroup(id);
        return ResponseEntity.ok().build();
    }
}
