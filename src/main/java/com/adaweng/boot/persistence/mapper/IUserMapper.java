package com.adaweng.boot.persistence.mapper;

import com.adaweng.boot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by eyaweng on 8/25/2017.
 */
//@Mapper
public interface IUserMapper {

//    @Select("SELECT * FROM USER")
    List<User> getUsers();

    Long save(User user);

//    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

//    @Delete("DELETE FROM users WHERE id =#{id}")
    Long delete(Long id);
}
