package com.tangcco.evaluation.service.impl;

import com.tangcco.evaluation.dao.RoleMapper;
import com.tangcco.evaluation.service.RoleService;
import com.tangcoo.evaluation.pojo.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleServiceImpl implements RoleService {
  @Resource
  private RoleMapper roleMapper;
    @Override
    public Role findRole(String roleId, String password) {
        System.out.println("进来了------");
        Role role=roleMapper.getRole(roleId);
        if(role!=null){
            if(role.getPassword().equals(password)){
                return  role;
            }
        }
        System.out.println(roleId);
        System.out.println(password);
        return roleMapper.getRole(password);
    }
}
