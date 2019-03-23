package com.tangcco.evaluation.service.impl;

import com.tangcco.evaluation.dao.ClassMapper;
import com.tangcco.evaluation.service.ClassService;
import com.tangcoo.evaluation.pojo.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassMapper classMapper;
    
    /** 
    * @Description: 用来登录使用的 
    * @Param: [] 
    * @return: java.util.List<com.tangcoo.evaluation.pojo.Class> 
    * @Author: ShiDunKai 
    * @Date: 2019/3/23 
    */ 
    @Override
    public List<Class> select() {
        return classMapper.selectAll();
    }
}
