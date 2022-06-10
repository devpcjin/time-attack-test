package com.example.java0610.controller;

import com.example.java0610.domain.User;
import com.example.java0610.domain.UserRepository;
import com.example.java0610.domain.UserRequestDto;
import com.example.java0610.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserRepository userReposiroty;

    private final UserService userService;

    @PostMapping("/api/create")
    public User createUser(@RequestBody UserRequestDto requestDto){
        User user = new User(requestDto);
        return userReposiroty.save(user);
    }

    @GetMapping("/api/read/{id}")
    public User searchUser(@PathVariable Long id, @RequestBody UserRequestDto requestDto){
        userService.search(id, requestDto);
        return id;
    }

}
