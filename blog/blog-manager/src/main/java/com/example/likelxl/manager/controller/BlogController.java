package com.example.likelxl.manager.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.likelxl.manager.common.Result;
import com.example.likelxl.manager.entity.MBlog;
import com.example.likelxl.manager.jwt.ShiroUtil;
import com.example.likelxl.manager.service.BlogService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @
 * @Description TODO
 * @Date: 2020/6/1 14:51
 * @Create by external_ll@163.com
 **/
@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/blogs")
    public Result list(@RequestParam(defaultValue = "1") Integer currentPage) {

        Page page = new Page(currentPage, 5);
        IPage pageData = blogService.page(page, new QueryWrapper<MBlog>().orderByDesc("created"));

        return Result.success(pageData);
    }


    @GetMapping("/blog/{id}")
    public Result detail(@PathVariable(name = "id") Long id) {
        MBlog blog = blogService.getById(id);
        Assert.notNull(blog, "该博客已被删除");

        return Result.success(blog);
    }

    @RequiresAuthentication
    @PostMapping("/blog/edit")
    public Result edit(@Validated @RequestBody MBlog blog) {

        MBlog temp = null;
        if(blog.getId() != null) {
            temp = blogService.getById(blog.getId());
            // 只能编辑自己的文章
            System.out.println(ShiroUtil.getProfile().getId());
            Assert.isTrue(temp.getUserId() == ShiroUtil.getProfile().getId().longValue(), "没有权限编辑");

        } else {

            temp = new MBlog();
            temp.setUserId(ShiroUtil.getProfile().getId().intValue());
            temp.setCreated(new Date());
            temp.setStatus(0);
        }

        BeanUtil.copyProperties(blog, temp, "id", "userId", "created", "status");
        blogService.saveOrUpdate(temp);

        return Result.success(null);
    }
}
