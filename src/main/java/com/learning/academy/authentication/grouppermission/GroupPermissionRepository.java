package com.learning.academy.authentication.grouppermission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupPermissionRepository extends JpaRepository<GroupPermission, Long> {
}
