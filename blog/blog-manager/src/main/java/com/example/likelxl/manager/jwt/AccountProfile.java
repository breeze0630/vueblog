package com.example.likelxl.manager.jwt;

import lombok.Data;

import java.io.Serializable;

/**
 * @
 * @Description TODO
 * @Date: 2020/5/31 11:23
 * @Create by external_ll@163.com
 **/
@Data
public class AccountProfile implements Serializable {

    private Long id;
    private String username;

    private String avatar;
}
