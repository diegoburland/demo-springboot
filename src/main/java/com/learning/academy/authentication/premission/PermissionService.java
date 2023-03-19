package com.learning.academy.authentication.premission;

import java.util.List;
import java.util.Optional;

public interface PermissionService {

    Permission createPermission(Permission permission);

    Optional<Permission> getPermissionById(Long id);

    List<Permission> getAllPermissions();

    Permission updatePermission(Permission permission);

    void deletePermission(Long id);

}
