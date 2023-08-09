package com.example.meat_project.domain.auth.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReqJoinDTO {

  @Valid
  @NotNull(message = "아이디를 입력해주세요.")
  private User user;

  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  @Getter
  public static class User {

    @NotBlank(message = "아이디를 입력해주세요.")
    @Size(min = 4, message = "아이디는 4자 이상 입력해주세요.")
    private String id;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(min = 4, message = "비밀번호는 4자 이상 입력해주세요.")
    private String password;

    private String userName;

    private String userPhoneNumber;

    private String userEmail;

    @NotBlank(message = "이메일을 입력해주세요.")
    @Pattern(regexp = "^(?!\\s*$).+", message = "주소를 입력해주세요.")
    private String userAddress;

  }
}
