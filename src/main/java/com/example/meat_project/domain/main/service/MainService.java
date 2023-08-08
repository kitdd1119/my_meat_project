package com.example.meat_project.domain.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.meat_project.domain.main.dto.MainUserDTO;
import com.example.meat_project.domain.main.dto.ResMainDTO;
import com.example.meat_project.model.user.entity.UserEntity;
import com.example.meat_project.model.user.repository.UserRepository;

@Service
@Transactional(readOnly = true)
public class MainService {

  @Autowired
  private UserRepository userRepository;

  public ResMainDTO getMainData() {
    List<UserEntity> userEntityList = userRepository.findAll();
    List<MainUserDTO> mainUserDTOList = new ArrayList<>();
    for (UserEntity userEntity : userEntityList) {
      MainUserDTO mainUserDTO = new MainUserDTO(userEntity.getIdx(), userEntity.getId());
      mainUserDTOList.add(mainUserDTO);
    }

    // 컨트롤러한테 dto를 넘겨준다.
    return new ResMainDTO(mainUserDTOList);

  }

}
