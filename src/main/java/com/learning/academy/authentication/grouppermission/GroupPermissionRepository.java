package com.learning.academy.authentication.grouppermission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupPermissionRepository extends JpaRepository<GroupPermission, Long> {
    List<GroupPermission> findByGroupId(Long groupId);
}
