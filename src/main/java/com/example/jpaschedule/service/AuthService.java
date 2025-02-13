package com.example.jpaschedule.service;

import com.example.jpaschedule.dto.LoginRequestDto;
import com.example.jpaschedule.dto.LoginResponseDto;
import com.example.jpaschedule.entity.User;
import com.example.jpaschedule.repository.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public LoginResponseDto login(LoginRequestDto dto, HttpServletRequest request, HttpServletResponse response) {
        User findUser = userRepository.findUserByEmailOrElseThrow(dto.getEmail());
        if (!findUser.getPassword().equals(dto.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }
        HttpSession session = request.getSession(false);
        if (session == null) {
            session = request.getSession(true);
        }
        session.setAttribute("sessionKey", findUser.getEmail());

        Cookie sessionCookie = new Cookie("sessionId", session.getId());
        sessionCookie.setPath("/");
        sessionCookie.setHttpOnly(true);
        sessionCookie.setMaxAge(3600);
        response.addCookie(sessionCookie);

        return new LoginResponseDto(findUser.getId(), findUser.getEmail(), findUser.getName());
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();

        Cookie sessionCookie = new Cookie("sessionId", null);
        sessionCookie.setPath("/");
        sessionCookie.setMaxAge(0);
        response.addCookie(sessionCookie);

        }
    }
}
