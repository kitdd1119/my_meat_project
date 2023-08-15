package com.example.meat_project.model.community.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import com.example.meat_project.model.user.entity.UserEntity;

@Entity
@Table(name = "COMMUNITY")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idx", callSuper = false)
public class CommunityEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idx", nullable = false, unique = true)
  private Long idx;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_idx", referencedColumnName = "idx", updatable = false, nullable = false)
  private UserEntity userEntity;

  @Column(name = "content", nullable = false)
  private String content;

  @Column(name = "done_yn", nullable = false)
  private String doneYn;

  @Column(name = "create_date", nullable = false)
  private LocalDateTime createDate;

  @Column(name = "update_date")
  private LocalDateTime updateDate;

  @Column(name = "delete_date")
  private LocalDateTime deleteDate;

  public void setDoneYn(String doneYn) {
    this.doneYn = doneYn;
    this.updateDate = LocalDateTime.now();
  }

  public void setDeleteDate(LocalDateTime deleteDate) {
    this.deleteDate = deleteDate;
  }

}
