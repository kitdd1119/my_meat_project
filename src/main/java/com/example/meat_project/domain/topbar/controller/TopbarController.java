package com.example.meat_project.domain.topbar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopbarController {

  @GetMapping("/topbar/map")
  public String map() {
    return "topbar/map";
  }

  @GetMapping("/topbar/myInformation")
  public String myInformation() {
    return "topbar/myInformation";
  }

  @GetMapping("/topbar/community")
  public String community() {
    return "topbar/community";
  }
}
