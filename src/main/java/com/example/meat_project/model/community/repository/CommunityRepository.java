package com.example.meat_project.model.community.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.meat_project.model.community.entity.CommunityEntity;

public interface CommunityRepository extends JpaRepository<CommunityEntity, Long> {

}
