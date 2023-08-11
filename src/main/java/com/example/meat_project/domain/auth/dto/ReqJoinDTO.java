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

    @NotBlank(message = "성함을 입력해주세요.")
    @Size(min = 2, message = "성함은 2자 이상 입력해주세요.")
    private String userName;

    @NotBlank(message = "전화번호를 입력해주세요.")
    @Pattern(regexp = "\\d{3}-\\d{4}-\\d{4}", message = "전화번호 형식은 '000-0000-0000'입니다.")
    private String userPhoneNumber;

    @NotBlank(message = "이메일을 입력해주세요.")
    @Pattern(regexp = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}", message = "올바른 이메일 형식이어야 합니다.")
    private String userEmail;

    @NotBlank(message = "주소를 입력해주세요.")
    @Pattern(regexp = ".*\\S.*", message = "주소는 공백을 제외한 값이 있어야 합니다.")
    private String userAddress;

  }
}
