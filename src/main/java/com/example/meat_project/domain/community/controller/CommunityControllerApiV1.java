package com.example.meat_project.domain.community.controller;

import com.example.meat_project.common.dto.LoginUserDTO;
import com.example.meat_project.common.exception.InvalidSessionException;
import com.example.meat_project.domain.community.dto.ReqCommunityTableInsertDTO;
import com.example.meat_project.domain.community.dto.ReqCommunityTableUpdateDoneYnDTO;
import com.example.meat_project.domain.community.service.CommunityServiceApiV1;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/community")
public class CommunityControllerApiV1 {

  private final CommunityServiceApiV1 communityServiceApiV1;

  @GetMapping
  public ResponseEntity<?> getCommunityTableData(HttpSession session) {
    return communityServiceApiV1.getCommunityTableData(getLoginUserDTO(session));
  }

  @PostMapping
  public ResponseEntity<?> insertCommunityTableData(
      @Valid @RequestBody ReqCommunityTableInsertDTO dto,
      HttpSession session) {
    return communityServiceApiV1.insertCommunityTableData(dto, getLoginUserDTO(session));
  }

  @PutMapping("/{communityIdx}")
  public ResponseEntity<?> updateCommunityTableData(
      @PathVariable Long communityIdx,
      @Valid @RequestBody ReqCommunityTableUpdateDoneYnDTO dto,
      HttpSession session) {
    return communityServiceApiV1.updateCommunityTableData(communityIdx, dto, getLoginUserDTO(session));
  }

  @DeleteMapping("/{communityIdx}")
  public ResponseEntity<?> deleteCommunityTableData(
      @PathVariable Long communityIdx,
      HttpSession session) {
    return communityServiceApiV1.deleteCommunityTableData(communityIdx, getLoginUserDTO(session));
  }

  private static LoginUserDTO getLoginUserDTO(HttpSession session) {
    if (session.getAttribute("loginUserDTO") == null) {
      throw new InvalidSessionException();
    }
    return (LoginUserDTO) session.getAttribute("loginUserDTO");
  }
}
