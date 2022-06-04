package com.bytedance.hego.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseCode {
    private Integer code;
    private String msg;
    private Object data;

    public ResponseCode(Integer code, String message) {
        this.code = code;
        this.msg = message;
    }
}
