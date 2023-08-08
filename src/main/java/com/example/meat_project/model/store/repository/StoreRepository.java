package com.example.meat_project.model.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.meat_project.model.store.entity.StoreEntity;

public interface StoreRepository extends JpaRepository<StoreEntity, Long> {

}
