package com.faydan.guopf.admin;

import com.faydan.guopf.entity.User;
import com.faydan.guopf.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserController created with IntelliJ IDEA.
 * User:  faydan
 * Email: fei321457749@126.com
 * Date:  2018-05-16
 * Time:  11:32
 * <p>
 * Describe:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

}
