package com.hd.sample_jpa_mysql_0605.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class ErrorResponse {
    private String code;
    private String message;
}