package com.tangcco.evaluation.dao;

import com.tangcoo.evaluation.pojo.Class;
import com.tangcoo.evaluation.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Component
public interface TeacherMapper extends Mapper<Teacher> {

    List<Teacher> getTeacher(@Param("typeId") Integer typeId,@Param("name")String name);

    Teacher getTeacherById(@Param("teacher_id") Integer teacher_id);

    Integer deleteTeacherById(@Param("teacherId") Integer teacherId);
    List<Teacher> getTeacherList(Class clazz);

    Teacher getTeacher2(Integer tid);


}