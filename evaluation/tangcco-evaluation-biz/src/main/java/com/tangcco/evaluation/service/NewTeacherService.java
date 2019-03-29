package com.tangcco.evaluation.service;

import com.tangcoo.evaluation.pojo.NewTeacher;

import java.util.List;

public interface NewTeacherService {
    /**
     * @author: lifan
     * @deprecated : 根据教师角色查询查询教师列表
     * @return
     */
    List<NewTeacher> selectTeacherById(NewTeacher teacherID);

    /**
     * @author: lifan
     * @deprecated : 根据教师角色查询查询教师列表
     * @return
     */
    List<NewTeacher> selectTeacherByclassTeacher(NewTeacher classTeacherID);
}
