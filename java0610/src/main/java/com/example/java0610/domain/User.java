package com.example.java0610.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class User {

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Builder
    public User(String email, String name, Integer age, Gender gender){
        this.email = email;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public User(UserRequestDto requestDto){
        this.email = requestDto.getEmail();
        this.name = requestDto.getName();
        this.age = requestDto.getAge();
        this.gender = requestDto.getGender() == 0 ? Gender.M : Gender.F;
    }

    public void update(UserRequestDto requestDto){
        this.name = requestDto.getName();
        this.age = requestDto.getAge();
        this.gender = requestDto.getGender()  == 0 ? Gender.M : Gender.F;
    }
}
