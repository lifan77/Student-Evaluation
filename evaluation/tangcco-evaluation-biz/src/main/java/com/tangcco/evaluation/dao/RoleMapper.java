package com.tangcco.evaluation.dao;

import com.tangcoo.evaluation.pojo.Role;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@Component
public interface RoleMapper extends Mapper<Role> {
    /*   *
     * @Description:登陆
     * @Param:[roleId]
     * @return:com.tangcoo.evaluation.pojo.Role
     * @Author:DongZhen
     * @Date:2019/3/29
     */
    Role getRole(String roleId);
}