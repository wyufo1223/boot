package com.adaweng.boot.controller;

import com.adaweng.boot.persistence.mapper.IUserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by eyaweng on 8/25/2017.
 */
@RequestMapping("user")
@RestController
@EnableAutoConfiguration
@MapperScan("com.adaweng.boot.persistence.mapper")
public class UserController {
    @Autowired
    private IUserMapper userMapper;

    @GetMapping("/list/all")
    public Object listAll(){
        return userMapper.getUsers();
    }
}
