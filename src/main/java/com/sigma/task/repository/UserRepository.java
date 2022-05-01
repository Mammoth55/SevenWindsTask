package com.sigma.task.repository;

import com.sigma.task.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getByCarNumber(String carNumber);
}