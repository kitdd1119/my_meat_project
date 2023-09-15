package com.example.meat_project.domain.auth.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.meat_project.common.dto.LoginUserDTO;
import com.example.meat_project.common.dto.ResponseDTO;
import com.example.meat_project.common.exception.BadRequestException;
import com.example.meat_project.domain.auth.dto.ReqJoinDTO;
import com.example.meat_project.domain.auth.dto.ReqLoginDTO;
import com.example.meat_project.model.user.entity.UserEntity;
import com.example.meat_project.model.user.entity.UserRoleEntity;
import com.example.meat_project.model.user.repository.UserRepository;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder; // PasswordConfig파일 안 BCryptPasswordEncoder 이놈이 리턴됨.

  public ResponseEntity<?> login(ReqLoginDTO dto, HttpSession session) {
    // 리파지토리에서 아이디로 삭제되지 않은 유저 찾기
    Optional<UserEntity> userEntityOptional = userRepository.findByIdAndDeleteDateIsNull(dto.getUser().getId()); // AndDeleteDateIsNull

    // 유효성 체크
    // if (dto.getUser().getId() == null ||
    // dto.getUser().getId().equals("") ||
    // dto.getUser().getPassword() == null ||
    // dto.getUser().getPassword().equals("")) {
    // throw new BadRequestException("아이디나 비밀번호를 입력해주세요.");
    // }
    if (userEntityOptional.isEmpty()) {
      throw new BadRequestException("존재하지 않는 사용자입니다.");
    }

    // 없으면 (존재하지 않는 사용자입니다.) 메시지 리턴
    if (userEntityOptional.isEmpty()) {
      throw new BadRequestException("존재하지 않는 사용자입니다.");
    }

    UserEntity userEntity = userEntityOptional.get();

    // 입력한 비밀번호를 해싱 (SHA-256 혹은 Bcrypt 사용)
    String inputPassword = dto.getUser().getPassword();
    boolean isPasswordMatch = passwordEncoder.matches(inputPassword, userEntity.getPassword());

    System.out.println("입력한 비밀번호: " + inputPassword);
    System.out.println("DB에 저장된 비밀번호: " + userEntity.getPassword());

    // System.out.println("입력한 비밀번호: " + dto.getUser().getPassword());
    // System.out.println("DB에 저장된 비밀번호: " + userEntity.getPassword());

    if (!isPasswordMatch) {
      throw new BadRequestException("비밀번호가 일치하지 않습니다.");
    }

    // 비밀번호가 일치하지 않으면 (비밀번호가 일치하지 않습니다.) 메시지 리턴
    // if (!userEntity.getPassword().equals(dto.getUser().getPassword())) {
    //   throw new BadRequestException("비밀번호가 일치하지 않습니다.");
    // }

    // 세션에 로그인 유저 정보 저장
    session.setAttribute("loginUserDTO", LoginUserDTO.of(userEntity));

    // 응답 데이터로 리턴하기 (로그인에 성공하였습니다.)
    return new ResponseEntity<>(
        ResponseDTO.builder()
            .code(0)
            .message("로그인에 성공하였습니다.")
            .build(),
        HttpStatus.OK);
  }

  @Transactional
  public ResponseEntity<?> join(ReqJoinDTO dto) {

    // 리파지토리에서 아이디로 유저 찾기
    Optional<UserEntity> userEntityOptional = userRepository.findById(dto.getUser().getId());

    // 회원가입 정보 입력했는지 확인
    if (dto.getUser() == null ||
        dto.getUser().getId() == null ||
        dto.getUser().getId().equals("") ||
        dto.getUser().getId().length() < 4 ||
        dto.getUser().getPassword() == null ||
        dto.getUser().getPassword().equals("") ||
        dto.getUser().getUserName() == null ||
        dto.getUser().getUserName().equals("") ||
        dto.getUser().getUserPhoneNumber() == null ||
        dto.getUser().getUserPhoneNumber().equals("") ||
        dto.getUser().getUserEmail() == null ||
        dto.getUser().getUserEmail().equals("") ||
        dto.getUser().getUserAddress() == null ||
        dto.getUser().getUserAddress().equals("")) {

      throw new BadRequestException("회원가입 정보를 올바르게 입력해주세요.");
    }

    // if (userEntityOptional.isPresent()) {
    // throw new BadRequestException("이미 존재하는 아이디입니다.");
    // }

    // 있으면 (이미 존재하는 아이디입니다.) 메시지 리턴
    if (userEntityOptional.isPresent()) {
      throw new BadRequestException("이미 존재하는 아이디입니다.");
    }

    String encodePassword = passwordEncoder.encode(dto.getUser().getPassword());

    // 없으면 회원가입 처리
    UserEntity userEntityForSaving = UserEntity.builder()
        .id(dto.getUser().getId())
        .password(encodePassword)
        .userName(dto.getUser().getUserName())
        .userPhoneNumber(dto.getUser().getUserPhoneNumber())
        .userEmail(dto.getUser().getUserEmail())
        .userAddress(dto.getUser().getUserAddress())
        .createDate(LocalDateTime.now())
        .build();

    // 'USER' 역할을 'user_role' 테이블에 추가
    UserRoleEntity userRoleEntity = new UserRoleEntity();
    userRoleEntity.setUserEntity(userEntityForSaving);
    userRoleEntity.setRole("USER");
    userRoleEntity.setCreateDate(LocalDateTime.now());

    userRepository.save(userEntityForSaving);

    // 응답 데이터로 리턴하기 (회원가입에 성공하였습니다.)
    return new ResponseEntity<>(
        ResponseDTO.builder()
            .code(0)
            .message("회원가입에 성공하였습니다.")
            .build(),
        HttpStatus.OK);

  }

}
