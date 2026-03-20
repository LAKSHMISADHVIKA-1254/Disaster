package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;              // ✅ ADD
import com.example.demo.entity.Role; // ✅ ADD
import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    List<User> findByRole(Role role);
}