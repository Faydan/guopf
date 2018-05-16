package com.faydan.guopf.service;

import com.faydan.guopf.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UserService created with IntelliJ IDEA.
 * User:  faydan
 * Email: fei321457749@126.com
 * Date:  2018-05-16
 * Time:  11:31
 * <p>
 * Describe:
 */
public interface UserService {
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
