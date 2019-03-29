package com.tangcco.evaluation.service;

import com.tangcoo.evaluation.pojo.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> findTeacher(Integer typeId,String name);

    Teacher findTeacherById(Integer teacher_id);

    Integer deleteTeacherById( Integer teacher_id);
}
