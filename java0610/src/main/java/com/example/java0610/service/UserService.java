package com.example.java0610.service;

import com.example.java0610.domain.User;
import com.example.java0610.domain.UserRepository;
import com.example.java0610.domain.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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

    @Transactional
    public Long recommend(Long id){
        User user = userRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        List<User> userList = userRepository.findAllByServiceAgeEqualsAndServiceGenderNot(user.getAge(), user.getGender());
        List<UserRequestDto> recommendList = new LinkedList<UserRequestDto>();
        for(User recommendUser : userList){
            recommendList.add(UserRequestDto.builder()
            )
        }
    }
}
