package com.example.meat_project.domain.community.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.meat_project.common.dto.LoginUserDTO;
import com.example.meat_project.common.dto.ResponseDTO;
import com.example.meat_project.common.exception.BadRequestException;
import com.example.meat_project.domain.community.dto.ReqCommunityTableInsertDTO;
import com.example.meat_project.domain.community.dto.ReqCommunityTableUpdateDoneYnDTO;
import com.example.meat_project.domain.community.dto.ResCommunityTableDTO;
import com.example.meat_project.model.community.entity.CommunityEntity;
import com.example.meat_project.model.community.repository.CommunityRepository;
import com.example.meat_project.model.user.entity.UserEntity;
import com.example.meat_project.model.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommunityServiceApiV1 {

  private final CommunityRepository communityRepository;
  private final UserRepository userRepository;

  public ResponseEntity<?> getCommunityTableData(LoginUserDTO loginUserDTO) {

    List<CommunityEntity> communityEntityList = communityRepository
        .findByUserEntity_IdxAndDeleteDateIsNull(loginUserDTO.getUser().getIdx());

    return new ResponseEntity<>(
        ResponseDTO.builder()
            .code(0)
            .message("목록 조회에 성공하였습니다.")
            .data(ResCommunityTableDTO.of(communityEntityList))
            .build(),
        HttpStatus.OK);
  }

  @Transactional
  public ResponseEntity<?> insertCommunityTableData(ReqCommunityTableInsertDTO dto, LoginUserDTO loginUserDTO) {

    if (dto == null || dto.getCommunity() == null || dto.getCommunity().getContent() == null
        || dto.getCommunity().getContent().trim().length() == 0) {
      throw new BadRequestException("할 일을 입력해주세요.");
    }

    Optional<UserEntity> userEntityOptional = userRepository
        .findByIdxAndDeleteDateIsNull(loginUserDTO.getUser().getIdx());

    if (userEntityOptional.isEmpty()) {
      throw new BadRequestException("존재하지 않는 사용자입니다.");
    }

    CommunityEntity communityEntity = CommunityEntity.builder()
        .userEntity(userEntityOptional.get())
        .content(dto.getCommunity().getContent())
        .doneYn("N")
        .createDate(LocalDateTime.now())
        .build();

    communityRepository.save(communityEntity);

    return new ResponseEntity<>(
        ResponseDTO.builder()
            .code(0)
            .message("할 일 추가에 성공하였습니다.")
            .build(),
        HttpStatus.OK);
  }

  @Transactional
  public ResponseEntity<?> updateCommunityTableData(Long communityIdx, ReqCommunityTableUpdateDoneYnDTO dto,
      LoginUserDTO loginUserDTO) {

    Optional<CommunityEntity> communityEntityOptional = communityRepository.findByIdxAndDeleteDateIsNull(communityIdx);

    if (communityEntityOptional.isEmpty()) {
      throw new BadRequestException("존재하지 않는 할 일입니다.");
    }

    CommunityEntity communityEntity = communityEntityOptional.get();

    if (!communityEntity.getUserEntity().getIdx().equals(loginUserDTO.getUser().getIdx())) {
      throw new BadRequestException("권한이 없습니다.");
    }

    communityEntity.setDoneYn(dto.getCommunity().getDoneYn());

    return new ResponseEntity<>(
        ResponseDTO.builder()
            .code(0)
            .message("할 일 수정에 성공하였습니다.")
            .build(),
        HttpStatus.OK);
  }

  @Transactional
  public ResponseEntity<?> deleteCommunityTableData(Long communityIdx, LoginUserDTO loginUserDTO) {

    Optional<CommunityEntity> communityEntityOptional = communityRepository.findByIdxAndDeleteDateIsNull(communityIdx);

    if (communityEntityOptional.isEmpty()) {
      throw new BadRequestException("존재하지 않는 할 일입니다.");
    }

    CommunityEntity communityEntity = communityEntityOptional.get();

    if (!communityEntity.getUserEntity().getIdx().equals(loginUserDTO.getUser().getIdx())) {
      throw new BadRequestException("권한이 없습니다.");
    }

    communityEntity.setDeleteDate(LocalDateTime.now());

    return new ResponseEntity<>(
        ResponseDTO.builder()
            .code(0)
            .message("할 일 삭제에 성공하였습니다.")
            .build(),
        HttpStatus.OK);
  }

}
