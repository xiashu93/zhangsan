package com.qianfeng.service;

import com.qianfeng.common.vo.ResultVo;
import com.qianfeng.pojo.User;

public interface UserService {

    //登陆
    ResultVo login(String name, String password);

    //注册
    ResultVo register(User user);
}
