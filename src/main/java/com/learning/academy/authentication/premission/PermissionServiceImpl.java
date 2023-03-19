package com.learning.academy.authentication.premission;

import com.learning.academy.authentication.auth.AuthenticationResponse;
import com.learning.academy.authentication.user.Role;
import com.learning.academy.authentication.user.User;
import com.learning.academy.exception.EmailAlreadyExistsException;
import com.learning.academy.exception.NameAlreadyExistsException;
import com.learning.academy.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    public Permission createPermission(Permission permission) {

        try {

            if (permissionRepository.findByName(permission.getName()).isPresent()) {
                throw new NameAlreadyExistsException("Permission with name " + permission.getName() + " already exists.");
            }
            return permissionRepository.save(permission);

        } catch (NameAlreadyExistsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    public Optional<Permission> getPermissionById(Long id) {
        return permissionRepository.findById(id);
    }

    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    public Permission updatePermission(Permission permission) {

        Optional<Permission> existingPermission = permissionRepository.findById(permission.getId());

        if (existingPermission.isPresent()) {
            Permission p = existingPermission.get();
            if (permission.getName() != null) {
                p.setName(permission.getName());
            }
            if (permission.getDescription() != null) {
                p.setDescription(permission.getDescription());
            }
            return permissionRepository.save(p);
        } else {
            throw new ResourceNotFoundException("Permission not found");
        }
    }

    public void deletePermission(Long id) {
        permissionRepository.deleteById(id);
    }

}
