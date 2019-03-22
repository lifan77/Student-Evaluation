package com.tangcco.evaluation.service;

import com.tangcoo.evaluation.pojo.User;

import java.util.List;

public interface UserService {
    /**
     * @return
     * @author:lifan
     * @deprecated :用户信息查询
     */
    List<User> queryAll();

    /**
    * @Description: 学生判断可登录情况后进行登录操作
    * @Param: [user]
    * @return: com.tangcoo.evaluation.pojo.User
    * @Author: ShiDunKai
    * @Date: 2019/3/22
    */
    User login(User user);
}
