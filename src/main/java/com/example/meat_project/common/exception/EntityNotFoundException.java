package com.example.meat_project.common.exception;

public class EntityNotFoundException extends RuntimeException {

  public EntityNotFoundException(String message) {
    super(message);
  }

  public EntityNotFoundException() {
    super("로그인이 필요합니다.");
  }
}
