package com.tangcco.evaluation.service.impl;

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

    /**
     * @author:lifan
     * @deprecated :测试tk.mybatis
     * @return
     */
    @Override
    public List<User> queryAll() {
        System.out.println("-------------------------------------------------------------------------");
        return userMapper.selectAll();
    }
}
