package com.example.jpaschedule.repository;

import com.example.jpaschedule.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Long id);

    User findUserByEmailOrElseThrow(String email);
}