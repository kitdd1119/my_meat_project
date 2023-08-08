package com.example.meat_project.model.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "`store`")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class StoreEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "store_idx", nullable = false, unique = true)
  private Long storeIdx;

  @Column(name = "store_address", nullable = false)
  private String storeAddress;

}
