package com.learning.academy.authentication.user;

import com.learning.academy.authentication.grouppermission.GroupPermission;
import com.learning.academy.authentication.grouppermission.GroupPermissionRepository;
import com.learning.academy.authentication.premission.Permission;
import com.learning.academy.authentication.premission.PermissionRepository;
import com.learning.academy.authentication.usergroup.UserGroup;
import com.learning.academy.authentication.usergroup.UserGroupRepository;
import com.learning.academy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private UserGroupRepository userGroupRepository;

    @Autowired
    private GroupPermissionRepository groupPermissionRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override

    public Optional<User> getUserById(Integer id) { return userRepository.findByIdAndActiveStatus(id);}

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAllByActiveStatus();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public Optional<User> getUserWithPermissions(Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            List<UserGroup> userGroups = userGroupRepository.findByUserId(userId);

            Set<Permission> permissions = new HashSet<>();
            for (UserGroup userGroup : userGroups) {
                List<GroupPermission> groupPermissions = groupPermissionRepository.findByGroupId(userGroup.getGroup().getId());
                for (GroupPermission groupPermission : groupPermissions) {
                    if(groupPermission.getPermission() != null){
                        permissions.add(groupPermission.getPermission());
                    }
                }
            }

            user.setPermissions(permissions);

            return Optional.of(user);
        }
        return Optional.empty();
    }

    public void updateStatus(Integer userId, String status) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            userRepository.updateStatus(userId, status);
        } else {
            throw new UsernameNotFoundException("User not found with id: " + userId);
        }
    }
}
