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
     * @author: lifan
     * @deprecated :根据条件模糊查询学生列表
     * @param offset 页码
     * @param pageSize 每页数量
     * @param className 班级名称
     * @param teacherId 教员姓名
     * @param classTeacherId  班主任姓名
     * @param gradeId
     * @param status
     * @return
     */
    List<User> selectUser(@Param("offset") Integer offset,
                          @Param("pageSize")  Integer pageSize,
                          @Param("className") String className,
                          @Param("teacherId") Integer teacherId,
                          @Param("classTeacherId") Integer classTeacherId,
                          @Param("gradeId") Integer gradeId,
                          @Param("status") Integer status );
}