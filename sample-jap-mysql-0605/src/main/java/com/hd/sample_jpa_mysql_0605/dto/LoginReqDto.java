package com.hd.sample_jpa_mysql_0605.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginReqDto {
    private String email;
    private String pwd;
}
