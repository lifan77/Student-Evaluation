package com.tangcco.evaluation.service.impl;

import com.tangcco.evaluation.dao.ClassMapper;
import com.tangcco.evaluation.service.ClassService;
import com.tangcoo.evaluation.dto.PageDto;
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

    /** 
    * @Description: 用来登录使用的 
    * @Param: [] 
    * @return: java.util.List<com.tangcoo.evaluation.pojo.Class> 
    * @Author: ShiDunKai 
    * @Date: 2019/3/23 
    */
    @Override
    public List<Class> select(Class c) {
        return classMapper.select(c);
    }

    @Override
    public PageDto<Class> selectClassByClassGrade(Integer pageNo, Integer pageSize, String className,Integer gradeId) {
        int offset=(pageNo-1)*pageSize;
        List<Class> classList = classMapper.selectClassByClassGrade(offset,pageSize,className,gradeId);
        Long classCount = (long)classMapper.getClassCount(className,gradeId);
        PageDto<Class> classPageDto =new PageDto<>();
        classPageDto.setTotal(classCount);
        classPageDto.setPageSize(pageSize);
        classPageDto.setPageNo(pageNo);
        classPageDto.setData(classList);
        int pages=(int)(classCount/pageSize+(classCount%pageSize>0?1:0));
        classPageDto.setPages(pages);
        return classPageDto;
    }

    @Override
    public Integer addClass(Class c) {
        return classMapper.insert(c);
    }

    @Override
    public Integer updateClass(Class c) {
        c.setClassId(12);
        c.setStatus(1);

        System.out.println("数据："+c);

        return classMapper.updateByPrimaryKeySelective(c);

    }

    @Override
    public Class selectClassById(Integer classId) {
        return classMapper.selectClassById(classId);
    }

    @Override
    public Integer updateClassById(Class c) {
        return classMapper.updateClassById(c);
    }

    @Override
    public Integer getClassCount(String className, Integer gradeId) {
        return classMapper.getClassCount(className,gradeId);
    }

}
