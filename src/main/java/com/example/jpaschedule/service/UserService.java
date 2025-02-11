package com.example.jpaschedule.service;

import com.example.jpaschedule.dto.UserRequestDto;
import com.example.jpaschedule.dto.UserResponseDto;
import com.example.jpaschedule.entity.User;
import com.example.jpaschedule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto saveUser(String name, String email, String password) { //유저 등록
        User user = new User(name, email, password);
        userRepository.save(user);

        return new UserResponseDto(user.getId(), user.getName(), user.getEmail(), user.getCreatedAt(), user.getUpdatedAt());
    }

    @Transactional(readOnly = true)
    public UserResponseDto findUserById(Long id) { //유저 단건 조회
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 Id에 해당하는 유저가 없습니다."));

        return new UserResponseDto(user.getId(), user.getName(), user.getEmail(), user.getCreatedAt(), user.getUpdatedAt());
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> findAllUser() { //전체 유저 조회
        List<User> findUsers = userRepository.findAll();
        List<UserResponseDto> dtoList = new ArrayList<>();
        for (User findUser : findUsers) {
            dtoList.add(new UserResponseDto(findUser.getId(), findUser.getName(), findUser.getEmail(), findUser.getCreatedAt(), findUser.getUpdatedAt()));

        }
        return dtoList;
    }

    @Transactional
    public UserResponseDto updateUser(Long id, UserRequestDto requestDto) { //유저 수정
        User user = userRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("해당 Id에 해당하는 유저가 없습니다."));
        user.update(requestDto.getName(), requestDto.getPassword(), requestDto.getEmail());
        return new UserResponseDto(user.getId(), user.getName(), user.getEmail(), user.getCreatedAt(), user.getUpdatedAt());
    }

    @Transactional
    public void deleteUser(Long id) { //유저 삭제
        userRepository.deleteById(id);
    }
}
