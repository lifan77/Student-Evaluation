package com.tangcco.evaluation.service.impl;

import com.tangcco.evaluation.dao.TeacherMapper;
import com.tangcco.evaluation.service.TeacherService;
import com.tangcoo.evaluation.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;




    /*  @Override
        public List<NewTeacher> selectTeacherById(NewTeacher teacherID) {

            return teacherMapper.select(teacherID);
        }

        @Override
        public List<Teacher> selectTeacherByclassTeacher(Teacher classTeacherID) {

            return teacherMapper.select(classTeacherID);
        }*/
    @Override
    public List<Teacher> findTeacher(Integer typeId,String name) {

        return teacherMapper.getTeacher(typeId,name);
    }

    @Override
    public Integer deleteTeacherById(Integer teacher_id) {
        return teacherMapper.deleteTeacherById(teacher_id);
    }

    @Override
    public Teacher findTeacherById(Integer teacher_id) {
        return teacherMapper.getTeacherById(teacher_id);
    }
}
