package com.learning.academy.authentication.grouppermission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupPermissionService {

    @Autowired
    private GroupPermissionRepository groupPermissionRepository;

    public GroupPermission createGroupPermission(GroupPermission groupPermission) {
        return groupPermissionRepository.save(groupPermission);
    }

    public Optional<GroupPermission> getGroupPermissionById(Long id) {
        return groupPermissionRepository.findById(id);
    }

    public List<GroupPermission> getAllGroupPermissions() {
        return groupPermissionRepository.findAll();
    }

    public GroupPermission updateGroupPermission(GroupPermission groupPermission) {
        return groupPermissionRepository.save(groupPermission);
    }

    public void deleteGroupPermission(Long id) {
        groupPermissionRepository.deleteById(id);
    }
}
