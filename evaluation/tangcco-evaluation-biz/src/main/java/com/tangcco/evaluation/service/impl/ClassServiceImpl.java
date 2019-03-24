package com.tangcco.evaluation.service.impl;

import com.tangcco.evaluation.dao.ClassMapper;
import com.tangcco.evaluation.service.ClassService;
import com.tangcoo.evaluation.dto.PageDto;
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
    public List<Class> select(Class c) {
        return classMapper.select(c);
    }

    @Override
    public Integer getClassCount(String className, String gradeName) {
        return classMapper.getClassCount(className,gradeName);
    }



    @Override
    public PageDto<Class> selectClassByClassGrade(Integer pageNo, Integer pageSize, String className, String gradeName) {
        int offset=(pageNo-1)*pageSize;
        List<Class> classList = classMapper.selectClassByClassGrade(offset,pageSize,className,gradeName);
        System.out.println(classList);
        Long classCount = (long)classMapper.getClassCount(className,gradeName);
        PageDto<Class> classPageDto =new PageDto<>();
        classPageDto.setTotal(classCount);
        classPageDto.setPageSize(pageSize);
        classPageDto.setPageNo(pageNo);
        classPageDto.setData(classList);
        int pages=(int)(classCount/pageSize+(classCount%pageSize>0?1:0));
        classPageDto.setPages(pages);
        return classPageDto;
    }

}
