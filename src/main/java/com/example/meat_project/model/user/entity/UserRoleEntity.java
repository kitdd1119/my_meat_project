package com.example.meat_project.model.user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "USER_ROLE")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idx", callSuper = false)
public class UserRoleEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idx", nullable = false, unique = true)
  private Long idx;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_idx", referencedColumnName = "idx", updatable = false, nullable = false)
  private UserEntity userEntity;

  @Column(name = "role")
  private String role;

  @Column(name = "create_date")
  private LocalDateTime createDate;

}
