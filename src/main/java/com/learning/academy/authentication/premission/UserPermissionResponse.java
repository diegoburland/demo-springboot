package com.learning.academy.authentication.premission;

import com.learning.academy.authentication.premission.Permission;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserPermissionResponse {
    private Integer userId;
    private Permission permission;
}
