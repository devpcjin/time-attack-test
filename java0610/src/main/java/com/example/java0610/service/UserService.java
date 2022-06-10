package com.example.java0610.service;

import com.example.java0610.domain.User;
import com.example.java0610.domain.UserRepository;
import com.example.java0610.domain.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long search(Long id){
        User user = userRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        return user.getId();
    }

    @Transactional
    public Long update(Long id, UserRequestDto requestDto){
        User user = userRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        user.update(requestDto);
        return user.getId();
    }
}
