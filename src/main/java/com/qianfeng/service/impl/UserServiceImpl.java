package com.qianfeng.service.impl;

import com.qianfeng.common.util.ResultUtil;
import com.qianfeng.common.vo.ResultVo;
import com.qianfeng.dao.UserMapper;
import com.qianfeng.pojo.User;
import com.qianfeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //登陆
    @Override
    public ResultVo login(String name, String password) {
        User user = userMapper.selectByName(name);

        if (user != null) {
            if (user.getPassword().equals(password)) {
                //登陆成功
                return ResultUtil.exec(true,"OK",user);
            }
        }


        return ResultUtil.exec(false,"用户名或密码不正确",null);
    }

    @Override
    public ResultVo register(User user) {
        User user1 = userMapper.selectByName(user.getName());
        if (user1 == null) {
            //注册用户
            userMapper.insert(user);
        } else {
            throw new RuntimeException("用户名已经存在");
        }
        return ResultUtil.exec(true,"注册成功",null);
    }
}
