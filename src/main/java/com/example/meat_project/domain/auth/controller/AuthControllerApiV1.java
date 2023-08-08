package com.example.meat_project.domain.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.meat_project.domain.auth.dto.ReqJoinDTO;
import com.example.meat_project.domain.auth.dto.ReqLoginDTO;
import com.example.meat_project.domain.auth.service.AuthService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthControllerApiV1 {

  private final AuthService authService;

  @PostMapping("/login")
  public ResponseEntity<?> login(@Valid @RequestBody ReqLoginDTO dto, HttpSession session) {
    return authService.login(dto, session);
  }

  @PostMapping("/join")
  public ResponseEntity<?> join(@Valid @RequestBody ReqJoinDTO dto) {
    return authService.join(dto);
  }

}
