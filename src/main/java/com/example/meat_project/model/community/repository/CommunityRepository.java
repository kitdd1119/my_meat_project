package com.example.meat_project.model.community.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.meat_project.model.community.entity.CommunityEntity;

public interface CommunityRepository extends JpaRepository<CommunityEntity, Long> {
  List<CommunityEntity> findByDeleteDateIsNull();

  List<CommunityEntity> findByUserEntity_IdxAndDeleteDateIsNull(Long userIdx);

  List<CommunityEntity> findByUserEntity_IdxAndDeleteDateIsNullOrderByIdxDesc(Long userIdx);

  Optional<CommunityEntity> findByIdx(Long idx);

  Optional<CommunityEntity> findByIdxAndDeleteDateIsNull(Long idx);

}
