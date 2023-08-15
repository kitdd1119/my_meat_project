package com.example.meat_project.domain.community.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ReqCommunityTableUpdateDoneYnDTO {

  @Valid
  @NotNull(message = "내용을 입력해주세요.")
  private Community community;

  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  @Getter
  public static class Community {
    @NotBlank(message = "완료 여부를 입력해주세요.")
    @Pattern(regexp = "^[NY]$", message = "doneYn은 N 또는 Y을 입력해주세요.")
    private String doneYn;
  }
}
