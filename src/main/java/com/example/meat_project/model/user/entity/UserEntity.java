package com.example.meat_project.model.user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "`user`")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
@EqualsAndHashCode(of = "idx", callSuper = false)
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idx", nullable = false, unique = true)
  private Long idx;

  @Column(name = "id", nullable = false, unique = true)
  private String id;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "create_date", nullable = false)
  private LocalDateTime createDate;

  @Column(name = "update_date")
  private LocalDateTime updateDate;

  @Column(name = "delete_date")
  private LocalDateTime deleteDate;

  @Column(name = "user_name", nullable = false, unique = true)
  private String userName;

  @Column(name = "user_phone_number", nullable = false, unique = true)
  private String userPhoneNumber;

  @Column(name = "userAddress", nullable = false)
  private String userAddress;

  @OneToMany(mappedBy = "userEntity", fetch = FetchType.EAGER)
  private List<UserRoleEntity> userRoleEntityList;

}