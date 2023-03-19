package com.learning.academy.authentication.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    @Modifying
    @Query("update User u set u.status = :status where u.id = :id")
    void updateStatus(@Param("id") Integer id, @Param("status") String status);

    @Query("select u from User u where u.id = :id and u.status = 'ACTIVE'")
    Optional<User> findByIdAndActiveStatus(@Param("id") Integer id);

    @Query("select u from User u where u.status = 'ACTIVE'")
    List<User> findAllByActiveStatus();

}
