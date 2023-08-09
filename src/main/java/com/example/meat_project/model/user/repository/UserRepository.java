package com.example.meat_project.model.user.repository;

import com.example.meat_project.model.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

  Optional<UserEntity> findByIdx(Long idx);

  Optional<UserEntity> findById(String id);

  Optional<UserEntity> findByPassword(String password);

  Optional<UserEntity> findByUserName(String userName);

  Optional<UserEntity> findByUserPhoneNumber(String userPhoneNumber);

  Optional<UserEntity> findByUserEmail(String userEmail);

  Optional<UserEntity> findByUserAddress(String userAddress);

  Optional<UserEntity> findByIdAndDeleteDateIsNull(String id);

  Optional<UserEntity> findByIdxAndDeleteDateIsNull(Long idx);
}
