package com.tangcco.evaluation.service;

import com.tangcoo.evaluation.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    /**
     * @author: lifan
     * @deprecated : 根据教师角色查询查询教师列表
     * @return
     */
    List<Teacher> selectTeacherById(Teacher teacherID);

    /**
     * @author: lifan
     * @deprecated : 根据教师角色查询查询教师列表
     * @return
     */
    List<Teacher> selectTeacherByclassTeacher(Teacher classTeacherID);
    List<Teacher> findTeacher(Integer typeId,String name);

    Teacher findTeacherById(Integer teacher_id);

    Integer deleteTeacherById( Integer teacher_id);
}
