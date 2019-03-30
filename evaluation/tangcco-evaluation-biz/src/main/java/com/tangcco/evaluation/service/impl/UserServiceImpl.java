package com.tangcco.evaluation.service.impl;

import com.tangcco.evaluation.dao.ClassMapper;
import com.tangcco.evaluation.dao.UserMapper;
import com.tangcco.evaluation.service.UserService;
import com.tangcoo.evaluation.dto.PageDto;
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

    @Override
    public Integer userLand(Integer userId) {
        return userMapper.userLand(userId);
    }


    /**
     * @author : lifan
     * @deprecated : 根据姓名、班级名称分页查询学员信息
     * @return
     */
    @Override
    public PageDto<User> selectUser(Integer pageNo, Integer pageSize,Integer classId, String name) {
        int offset = (pageNo-1)*pageSize;
        List<User> userList = userMapper.selectUser(offset,pageSize,classId,name);
        Long userCount =(long)userMapper.getUserCount(classId,name);
        PageDto<User> userPageDto = new PageDto<>();
        userPageDto.setTotal(userCount);
        userPageDto.setPageNo(pageNo);
        userPageDto.setPages(pageSize);
        userPageDto.setData(userList);
        int pages=(int)(userCount/pageSize+(userCount%pageSize>0?1:0));
        userPageDto.setPages(pages);
        return userPageDto;
    }




}
