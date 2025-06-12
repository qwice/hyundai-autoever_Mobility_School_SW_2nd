package com.hd.sample_jpa_mysql_0605.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BoardResDto {
    private Long boardId;
    private String title;
    private String content;
    private String img;
    private String email;
    private LocalDateTime createTime;
}
