package com.tangcco.evaluation.dao;

import com.tangcoo.evaluation.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

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

    /**
     * @author : lifan
     * @deprecated : 根据姓名、班级名称或班级类型分页查询学员信息
     * @param offset
     * @param pageSize
     * @param classId
     * @param name
     * @return
     */
    List<User> selectUser(@Param("offset") Integer offset,
                          @Param("pageSize")  Integer pageSize,
                          @Param("classId") Integer classId,
                          @Param("name") String name);

    /**
     * @author:lifan
     * @deprecated : 查询学员总人数
     * @param classId
     * @param name
     * @return
     */
    Integer getUserCount(@Param("classId") Integer classId,
                         @Param("name") String name);
}