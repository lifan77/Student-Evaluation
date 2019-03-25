package com.tangcco.evaluation.service;

import com.tangcoo.evaluation.dto.PageDto;
import com.tangcoo.evaluation.pojo.Class;

import java.util.List;

public interface ClassService {
    List<Class> findAllByExample(Integer gradeId);
    /**
     * @Description: 查询答卷用
     * @Param:
     * @return:
     * @Author: ShiDunKai
     * @Date: 2019/3/22
     */
    List<Class> select(Class c);

    /**
     * @author:lifan
     * @param pageNo 页面
     * @param pageSize 页面数量
     * @param className 班级名称
     * @param gradeName  年级名称
     * @deprecated :根据年级名称或者班级名称模糊查询班级列表
     * @return
     */
      PageDto<Class> selectClassByClassGrade(Integer pageNo, Integer pageSize, String className, String gradeName);

    /**
     * @author:lifan
     * @param className 班级名称
     * @param gradeName 年级名称
     * @deprecated :查询班级总数量
     * @return
     */
    Integer getClassCount( String className,String gradeName);
}
