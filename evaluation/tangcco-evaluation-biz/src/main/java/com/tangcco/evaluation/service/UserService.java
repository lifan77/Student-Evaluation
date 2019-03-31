package com.tangcco.evaluation.service;

import com.tangcoo.evaluation.dto.PageDto;
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
    Integer userLand(Integer userId);


    /**
     * @author : lifan
     * @deprecated : 根据姓名、班级名称或班级类型分页查询学员信息
     * @param pageNo
     * @param pageSize
     * @param classId
     * @param name
     * @return
     */
    PageDto<User> selectUser(Integer pageNo, Integer pageSize,Integer classId, String name);

    /**
     * @author : lifan
     * @deprecated  :  新增学生
     * @param user
     * @return
     */
    Integer addUser(User user);

    /**
     * @author:lifan
     * @deprecated : 修改学生信息
     * @param user
     * @return
     */
    Integer updateUser(User user);

    /**
     * @author: lifan
     * @deprecated : 根基id查询
     * @param id
     * @return
     */
    User selectByid(Integer id);
}
