package com.example.java0617.repository;

import com.example.java0617.domain.Gender;
import com.example.java0617.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String myServiceEmail);
    List<Member> findAllByMyServiceAgeEqualsAndMyServiceGenderNot(int myServiceAge, Gender myServiceGender);
}
