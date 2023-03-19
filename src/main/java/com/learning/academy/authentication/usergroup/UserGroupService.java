package com.learning.academy.authentication.usergroup;

import com.learning.academy.exception.NameAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserGroupService {

    @Autowired
    private UserGroupRepository userGroupRepository;

    public UserGroup createUserGroup(UserGroup userGroup) {

        try {
            return userGroupRepository.save(userGroup);

        } catch (NameAlreadyExistsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }

    }

    public Optional<UserGroup> getUserGroupById(Long id) {
        return userGroupRepository.findById(id);
    }

    public List<UserGroup> getAllUserGroups() {
        return userGroupRepository.findAll();
    }

    public UserGroup updateUserGroup(UserGroup userGroup) {
        return userGroupRepository.save(userGroup);
    }

    public void deleteUserGroup(Long id) {
        userGroupRepository.deleteById(id);
    }
}
