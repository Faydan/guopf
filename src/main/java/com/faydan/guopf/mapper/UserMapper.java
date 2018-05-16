package com.faydan.guopf.mapper;

import com.faydan.guopf.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * 新增用户
     */
    void saveUser(User user);

    /**
     * 修改用户
     */
    void updateUser(User user);

    /**
     * 根据用户名查询用户
     */
    User findByUsername(String username);
}