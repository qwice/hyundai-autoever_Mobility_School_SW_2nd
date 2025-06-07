package com.hd.sample_jpa_mysql_0605.dto;

import lombok.Data;

@Data
public class LoginReqDto {
    private String email;
    private String pwd;
}
