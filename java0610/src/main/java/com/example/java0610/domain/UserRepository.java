package com.example.java0610.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByServiceAgeEqualsAndServiceGenderNot(Integer age, Gender gender);
}
