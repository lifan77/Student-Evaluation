package com.tangcco.evaluation.service.impl;

import com.tangcco.evaluation.dao.ClassMapper;
import com.tangcco.evaluation.dao.UserMapper;
import com.tangcco.evaluation.service.UserService;
import com.tangcoo.evaluation.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    ClassMapper classMapper;

    /**
     * @return
     * @author:lifan
     * @deprecated :测试tk.mybatis
     */
    @Override
    public List<User> queryAll() {
        System.out.println("-------------------------------------------------------------------------");
        return userMapper.selectAll();
    }

    /**
     * @Description: 实现登录操作
     * @Param: [user]
     * @return: com.tangcoo.evaluation.pojo.User
     * @Author: ShiDunKai
     * @Date: 2019/3/22
     */
    @Override
    public User login(User user) {
        return userMapper.login(user);
    }



}
