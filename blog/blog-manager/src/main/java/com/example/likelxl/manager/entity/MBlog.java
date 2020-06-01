package com.example.likelxl.manager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @
 * @Description TODO
 * @Date: 2020/5/31 17:28
 * @Create by external_ll@163.com
 **/
@Data
@TableName("m_blog")
public class  MBlog implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("user_id")
    private int userId;

    @TableField("title")
    private String title;

    @TableField("description")
    private String description;

    @TableField("content")
    private String content;

    @TableField("created")
    private Date created;

    @TableField("status")
    private int status;
}
