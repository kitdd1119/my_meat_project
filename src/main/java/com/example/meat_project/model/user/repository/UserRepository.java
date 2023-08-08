package com.example.meat_project.model.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.meat_project.model.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

  Optional<UserEntity> findById(String id);

  Optional<UserEntity> findByIdAndDeleteDateIsNull(String id);

  Optional<UserEntity> findByIdxAndDeleteDateIsNull(Long idx);
}
