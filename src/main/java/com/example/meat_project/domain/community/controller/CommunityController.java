package com.example.meat_project.domain.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.meat_project.common.dto.LoginUserDTO;
import com.example.meat_project.domain.community.dto.ResCommunityTableDTO;
import com.example.meat_project.domain.community.service.CommunityService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CommunityController {

  private final CommunityService communityService;

  @GetMapping({ "", "/community" })
  public ModelAndView communityTablePage(HttpSession session) {
    ModelAndView modelAndView = new ModelAndView();

    if (session.getAttribute("loginUserDTO") == null) {
      modelAndView.setViewName("redirect:/auth/login");
      return modelAndView;
    }

    LoginUserDTO loginUserDTO = (LoginUserDTO) session.getAttribute("loginUserDTO");
    ResCommunityTableDTO dto = communityService.getCommunityTableData(loginUserDTO);
    modelAndView.addObject("dto", dto);
    modelAndView.setViewName("topbar/community"); // 주소 한 번 확인할 필요 있음.
    return modelAndView;
  }

}
