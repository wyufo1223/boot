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
    List<User> getAllUsers();

    User getUserById(Long id);

    List<User> getUserByName(String name);

    Long save(User user);

//    @Delete("DELETE FROM users WHERE id =#{id}")
    Long delete(Long id);

	void update(Long id, User u);
}
