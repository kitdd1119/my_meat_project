package com.example.meat_project.domain.community.dto;

import java.util.List;

import com.example.meat_project.model.community.entity.CommunityEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ResCommunityTableDTO {

  private List<Community> communityList;
  private List<Community> doneList;

  public static ResCommunityTableDTO of(List<CommunityEntity> communityEntityList) {
    return ResCommunityTableDTO.builder()
        .communityList(
            communityEntityList.stream()
                .filter(communityEntity -> communityEntity.getDoneYn().equals("N"))
                .map(communityEntity -> Community.fromEntity(communityEntity))
                .toList())
        .doneList(
            communityEntityList.stream()
                .filter(communityEntity -> communityEntity.getDoneYn().equals("Y"))
                .map(communityEntity -> Community.fromEntity(communityEntity))
                .toList())
        .build();

  }

  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  @Getter
  private static class Community {
    private Long idx;
    private String content;
    private String doneYn;

    public static Community fromEntity(CommunityEntity communityEntity) {
      return Community.builder()
          .idx(communityEntity.getIdx())
          .content(communityEntity.getContent())
          .doneYn(communityEntity.getDoneYn())
          .build();
    }
  }
}
