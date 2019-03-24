package com.qianfeng.dao;

import com.qianfeng.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    //添加、注册
    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //查询方法
    User selectByName(String name);
}