package com.tangcco.evaluation.service.impl;

import com.tangcco.evaluation.dao.ClassMapper;
import com.tangcco.evaluation.service.ClassService;
import com.tangcoo.evaluation.pojo.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassMapper classMapper;
    @Override
    public List<Class> findAllByExample(Integer gradeId) {
        Example example=new Example(Class.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("gradeId",gradeId);
        return classMapper.selectByExample(example);
    }
}
