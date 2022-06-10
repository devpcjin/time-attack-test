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
    public Long searchUser(@PathVariable Long id){
        userService.search(id);
        return id;
    }

    @PutMapping("/api/update/{id}")
    public Long updateUser(@PathVariable Long id, @RequestBody UserRequestDto requestDto){
        userService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/delete/{id}")
    public Long deleteUser(@PathVariable Long id){
        userReposiroty.deleteById(id);
        return id;
    }

    @GetMapping("/api/recommend/{id}")
    public Long recommendUser(@PathVariable Long id){
        userService.recommend(id);
        return id;
    }

}
