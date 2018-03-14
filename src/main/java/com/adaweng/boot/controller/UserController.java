package com.adaweng.boot.controller;

import com.adaweng.boot.entity.User;
import com.adaweng.boot.persistence.mapper.IUserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@EnableAutoConfiguration
@MapperScan("com.adaweng.boot.persistence.mapper")
public class UserController {
    @Autowired
    private IUserMapper userMapper;

    @RequestMapping(value = "/", method=RequestMethod.GET)
    @Cacheable(value="user-key")
    public Object getAllUsers(){
        return userMapper.getAllUsers();
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Object getUserById(@PathVariable Long id){
    	User u = userMapper.getUserById(id);
        return u;
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public Object getUserByName(@PathVariable String name){
        return userMapper.getUserByName(name);
    }
    
    @RequestMapping(value="/", method=RequestMethod.POST) 
    public String postUser(@ModelAttribute User user) { 
    	userMapper.save(user); 
        return "success"; 
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.PUT) 
    public String putUser(@PathVariable Long id, @ModelAttribute User user) { 
        User u = userMapper.getUserById(id); 
        u.setName(user.getName()); 
        u.setBirthday(user.getBirthday()); 
        userMapper.update(id, u); 
        return "success"; 
    } 
    
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE) 
    public String deleteUser(@PathVariable Long id) { 
    	userMapper.delete(id); 
        return "success"; 
    } 
}
