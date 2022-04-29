package com.example.sevenwindstask.repository;

import com.example.sevenwindstask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getByCarNumber(String carNumber);
}