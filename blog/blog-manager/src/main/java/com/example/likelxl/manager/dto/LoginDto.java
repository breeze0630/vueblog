package com.example.likelxl.manager.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @
 * @Description TODO
 * @Date: 2020/5/31 17:44
 * @Create by external_ll@163.com
 **/
@Data
public class LoginDto implements Serializable {

    private String username;

    private String password;
}
