package com.learning.academy.authentication.user;

import com.learning.academy.authentication.premission.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public User createUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Error creating user: " + e.getMessage());
        }
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        try {
            return userRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error getting user by ID: " + e.getMessage());
        }
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        try {
            return userRepository.findByEmail(email);
        } catch (Exception e) {
            throw new RuntimeException("Error getting user by email: " + e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error getting all users: " + e.getMessage());
        }
    }

    @Override
    public User updateUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Error updating user: " + e.getMessage());
        }
    }

    @Override
    public void deleteUser(Integer id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting user: " + e.getMessage());
        }
    }
}