package com.example.meat_project.common.dto;

import com.example.meat_project.model.user.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
public class LoginUserDTO {

  private User user;

  public static LoginUserDTO of(UserEntity userEntity) {
    return LoginUserDTO.builder()
        .user(User.fromEntity(userEntity))
        .build();
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  @Builder
  @ToString
  public static class User {
    private Long idx;
    private String id;
    private String password;

    public static User fromEntity(UserEntity userEntity) {
      return User.builder()
          .idx(userEntity.getIdx())
          .id(userEntity.getId())
          .password(userEntity.getPassword())
          .build();
    }
  }
}
