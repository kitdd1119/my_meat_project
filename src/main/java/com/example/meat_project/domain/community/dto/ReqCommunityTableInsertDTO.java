package com.example.meat_project.domain.community.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ReqCommunityTableInsertDTO {

  @Valid
  @NotNull(message = "내용을 양식에 맞게 입력해주세요.")
  private Community community;

  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  @Getter
  public static class Community {
    @NotBlank(message = "내용을 입력해주세요.")
    private String content;
  }
}
