package com.learning.academy.authentication.user;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    Optional<User> getUserById(Integer id);
    Optional<User> getUserByEmail(String email);
    List<User> getAllUsers();
    User updateUser(User user);
    void deleteUser(Integer id);
}

