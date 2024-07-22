package com.example.Task.Repository;

import com.example.Task.Entity.*;



import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

