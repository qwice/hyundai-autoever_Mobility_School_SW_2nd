package com.hd.sample_jpa_mysql_0605.dto;

import lombok.Getter;

@Getter
public class MemberReqDto {
    private String email;
    private String pwd;
    private String name;
}