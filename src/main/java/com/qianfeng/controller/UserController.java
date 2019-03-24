package com.qianfeng.controller;

import com.qianfeng.common.vo.ResultVo;
import com.qianfeng.pojo.User;
import com.qianfeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

     //登陆
    @RequestMapping("/login.do")
    public ResultVo login(String name, String password, HttpServletRequest request) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        request.getSession().setAttribute("user",user);
        return userService.login(name,password);
    }

    //注册
    @RequestMapping("/register.do")
    public ResultVo register(User user) {
        return userService.register(user);
    }
}
