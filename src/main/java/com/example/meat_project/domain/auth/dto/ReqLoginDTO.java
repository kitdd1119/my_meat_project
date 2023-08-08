package com.example.meat_project.domain.auth.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReqLoginDTO {
  @Valid
  @NotNull
  private User user;

  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  @Builder
  public static class User {
    @NotBlank
    private String id;

    @NotBlank
    private String password;

  }

}
