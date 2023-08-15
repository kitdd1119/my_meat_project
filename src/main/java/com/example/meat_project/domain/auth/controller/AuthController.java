package com.example.meat_project.domain.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

  @GetMapping("/auth/login")
  public String login() {
    return "auth/login";
  }

  @GetMapping("/auth/join")
  public String join() {
    return "auth/join";
  }

  @GetMapping("/auth/logout")
  public String logout(HttpSession session) {
    session.removeAttribute("dto");
    return "redirect:/auth/login";
  }
}
