package com.example.meat_project.domain.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

  private final HttpSession httpSession; // HttpSession 필드 추가

  // 생성자 주입으로 HttpSession 주입 받음
  public AuthController(HttpSession httpSession) {
    this.httpSession = httpSession;
  }

  @GetMapping("/auth/login")
  public String login() {
    return "auth/login";
  }

  @GetMapping("/auth/join")
  public String join() {
    return "auth/join";
  }

  @GetMapping("/auth/logout")
  public String logout() {
    httpSession.removeAttribute("dto"); // 세션에서 "dto" 제거
    return "redirect:/";
  }
}
