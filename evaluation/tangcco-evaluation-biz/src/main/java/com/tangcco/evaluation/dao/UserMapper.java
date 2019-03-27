package com.tangcco.evaluation.dao;

import com.tangcoo.evaluation.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@Component
public interface UserMapper extends Mapper<User> {

    /**
    * @Description: 学生登录，判断前提是此班级发布测评
    * @Param: []
    * @return: java.lang.Integer
    * @Author: ShiDunKai
    * @Date: 2019/3/22
    */
    User login(@Param("user") User user);

    /**
    * @Description: 根据userid修改他的状态
    * @Param: [userId]
    * @return: java.lang.Integer
    * @Author: ShiDunKai
    * @Date: 2019/3/27
    */
    Integer userLand(@Param("userId") Integer userId);
}