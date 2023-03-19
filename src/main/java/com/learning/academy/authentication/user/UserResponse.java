package com.learning.academy.authentication.user;

import com.learning.academy.authentication.premission.Permission;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserResponse {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private List<Permission> permissions;

    public UserResponse(Integer id, String name, String email, String phone, List<Permission> permissions) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.permissions = permissions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
