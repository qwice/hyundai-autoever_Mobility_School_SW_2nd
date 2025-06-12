package com.hd.sample_jpa_mysql_0605.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "board")
@Data
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // board_id

    @Column(length = 256, nullable = false)
    private String title; // 게시글 제목

    @Lob // 대용량 덱스트
    private String content; // 게시글 내용
    private String image; // 게시글에 첨부될 이미지의 주소
    private LocalDateTime createTime;

    @PrePersist
    public void prePersist() {
        this.createTime = LocalDateTime.now(); // DB에 쓰기 직전에 시간이 포함
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


}
