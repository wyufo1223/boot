package com.adaweng.boot.controller;

import com.adaweng.boot.persistence.mapper.IUserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

/**
 * Created by eyaweng on 8/25/2017.
 */
@RequestMapping("/users")
@RestController
@EnableAutoConfiguration
@MapperScan("com.adaweng.boot.persistence.mapper")
public class UserController {
    @Autowired
    private IUserMapper userMapper;

    @RequestMapping("")
    public Object getAllUsers(){
        return userMapper.getAllUsers();
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Object getUserById(@PathVariable Long id){
        return userMapper.getUserById(id);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public Object getUserByName(@PathVariable String name){
        return userMapper.getUserByName(name);
    }
}
