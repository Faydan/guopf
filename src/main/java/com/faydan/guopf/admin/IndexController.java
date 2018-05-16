package com.faydan.guopf.admin;

import com.faydan.guopf.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * IndexController created with IntelliJ IDEA.
 * User:  faydan
 * Email: fei321457749@126.com
 * Date:  2018-05-16
 * Time:  13:24
 * <p>
 * Describe:
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index/index";
    }

    @GetMapping("/login")
    public String toLogin() {
        return "index/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session
    ) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            User user = (User) subject.getPrincipal();
            session.setAttribute("user", user);
            return "登录成功!";
        } catch (Exception e) {
            e.printStackTrace();
            return "登录失败";
        }
    }

    @GetMapping("/logout")
    @ResponseBody
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "退出登录";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin() {
        return "admin";
    }

    @GetMapping("/edit")
    @ResponseBody
    public String edit() {
        return "edit";
    }

    @GetMapping("/error/403")
    public String error403() {
        return "error/403";
    }
}
