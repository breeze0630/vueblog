package com.example.likelxl.manager.jwt;


import org.apache.shiro.authc.AuthenticationToken;

/**
 * @
 * @Description TODO
 * @Date: 2020/5/31 11:11
 * @Create by external_ll@163.com
 **/
public class JwtToken implements AuthenticationToken {


    private String token;

    public JwtToken(String token){
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
