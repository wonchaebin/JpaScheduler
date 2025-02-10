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
    public UserResponseDto saveUser(String name, String email, String password) {
        User user = new User(name, email, password);
        userRepository.save(user);

        return new UserResponseDto(user.getId(), user.getName(), user.getEmail());
    }

    @Transactional(readOnly = true)
    public UserResponseDto findUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 Id에 해당하는 유저가 없습니다."));

        return new UserResponseDto(user.getId(), user.getName(), user.getEmail());
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> findAllUser() {
        List<User> findUsers = userRepository.findAll();
        List<UserResponseDto> dtoList = new ArrayList<>();
        for (User findUser : findUsers) {
            dtoList.add(new UserResponseDto(findUser.getId(), findUser.getName(), findUser.getEmail()));

        }
        return dtoList;
    }

    public void update(Long id, UserRequestDto requestDto) {
        
    }

    public void deleteUser(Long id) {

    }
}
