package com.example.meat_project.model.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.meat_project.model.user.entity.UserRoleEntity;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

  List<UserRoleEntity> findByUserEntity_Idx(Long userId);

  UserRoleEntity findByUserEntity_IdxAndRole(Long userId, String role);

}
