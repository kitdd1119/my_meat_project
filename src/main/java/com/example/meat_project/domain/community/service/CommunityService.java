package com.example.meat_project.domain.community.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.meat_project.common.dto.LoginUserDTO;
import com.example.meat_project.domain.community.dto.ResCommunityTableDTO;
import com.example.meat_project.model.community.entity.CommunityEntity;
import com.example.meat_project.model.community.repository.CommunityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommunityService {

  private final CommunityRepository communityRepository;

  public ResCommunityTableDTO getCommunityTableData(LoginUserDTO loginUserDTO) {
    List<CommunityEntity> communityEntityList = communityRepository
        .findByUserEntity_IdxAndDeleteDateIsNull(loginUserDTO.getUser().getIdx());

    return ResCommunityTableDTO.of(communityEntityList);
  }

}
