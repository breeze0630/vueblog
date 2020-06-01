package com.example.likelxl.manager.jwt;

import org.apache.shiro.SecurityUtils;

/**
 * @
 * @Description TODO
 * @Date: 2020/6/1 14:54
 * @Create by external_ll@163.com
 **/
public class ShiroUtil {

    public static AccountProfile getProfile() {
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }

}
