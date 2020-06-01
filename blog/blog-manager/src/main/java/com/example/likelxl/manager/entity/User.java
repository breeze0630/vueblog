package com.example.likelxl.manager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @
 * @Description TODO
 * @Date: 2020/5/31 10:29
 * @Create by external_ll@163.com
 **/
@Data
@TableName("m_user")
public class User implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    @NotBlank(message = "昵称不能为空")
    @TableField("username")
    private String username;
    @NotBlank(message = "头像不能为空")
    @TableField("avatar")
    private String avatar;
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    @TableField("email")
    private String email;

    @TableField("password")
    private String password;

    @TableField("status")
    private int status;

    @TableField("created")
    private Date created;
    @TableField("last_login")
    private Date lastLogin;


}
