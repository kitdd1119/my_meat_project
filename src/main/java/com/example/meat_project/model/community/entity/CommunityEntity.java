package com.example.meat_project.model.community.entity;

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
@Table(name = "`community`")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CommunityEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "post_num", nullable = false, unique = true)
  private Long postNum;

  @Column(name = "id", nullable = false, unique = true)
  private String id;

  @Column(name = "user_name", nullable = false, unique = true)
  private String userName;

  @Column(name = "post_title", nullable = false, unique = true)
  private String postTitle;

  @Column(name = "post_content", nullable = false)
  private String postContent;
}
