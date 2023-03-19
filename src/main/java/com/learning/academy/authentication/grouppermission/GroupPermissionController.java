package com.learning.academy.authentication.grouppermission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/group_permissions")
public class GroupPermissionController {

    @Autowired
    private GroupPermissionService groupPermissionService;

    @PostMapping
    public ResponseEntity<GroupPermission> createGroupPermission(@RequestBody GroupPermission groupPermission) {
        return ResponseEntity.ok(groupPermissionService.createGroupPermission(groupPermission));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupPermission> getGroupPermissionById(@PathVariable Long id) {
        return groupPermissionService.getGroupPermissionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<GroupPermission>> getAllGroupPermissions() {
        return ResponseEntity.ok(groupPermissionService.getAllGroupPermissions());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroupPermission> updateGroupPermission(@PathVariable Long id, @RequestBody GroupPermission groupPermission) {
        groupPermissionService.getGroupPermissionById(id).orElseThrow(() -> new RuntimeException("GroupPermission not found"));
        groupPermission.setId(id);
        return ResponseEntity.ok(groupPermissionService.updateGroupPermission(groupPermission));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroupPermission(@PathVariable Long id) {
        groupPermissionService.deleteGroupPermission(id);
        return ResponseEntity.ok().build();
    }
}
