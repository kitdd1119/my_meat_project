package com.example.meat_project.common.exception;

public class BadRequestException extends RuntimeException {

  public BadRequestException(String message) {
    super(message);
  }

  public BadRequestException() {
    super("잘못된 요청입니다.");
  }

}
