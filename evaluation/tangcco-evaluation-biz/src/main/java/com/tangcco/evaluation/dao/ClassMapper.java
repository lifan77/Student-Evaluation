package com.tangcco.evaluation.dao;

import com.tangcoo.evaluation.pojo.Class;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Component
public interface ClassMapper extends Mapper<Class> {
    /**
     * @author:lifan
     * @param offset 页面
     * @param pageSize 页面数量
     * @param className 班级名称
     * @param gradeName  年级名称
     * @deprecated :根据年级名称或者班级名称模糊查询班级列表
     * @return
     */
       List<Class> selectClassByClassGrade(@Param("offset") Integer offset,
                                           @Param("pageSize")  Integer pageSize,
                                           @Param("className") String className,
                                           @Param("gradeName") String gradeName);

    /**
     * @author:lifan
     * @param className 班级名称
     * @param gradeName 年级名称
     * @deprecated :查询班级总数量
     * @return
     */
        Integer getClassCount(@Param("className") String className,
                              @Param("gradeName") String gradeName);
}