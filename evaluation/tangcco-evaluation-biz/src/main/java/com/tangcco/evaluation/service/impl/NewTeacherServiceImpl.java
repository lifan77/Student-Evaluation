package com.tangcco.evaluation.service.impl;

import com.tangcco.evaluation.dao.NewTeacherMapper;
import com.tangcco.evaluation.service.NewTeacherService;
import com.tangcoo.evaluation.pojo.NewTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewTeacherServiceImpl implements NewTeacherService {
    @Autowired
    private NewTeacherMapper newTeacherMapper;

    @Override
    public List<NewTeacher> selectTeacherById(NewTeacher teacherID) {
        return newTeacherMapper.select(teacherID);
    }

    @Override
    public List<NewTeacher> selectTeacherByclassTeacher(NewTeacher classTeacherID) {
        return newTeacherMapper.select(classTeacherID);
    }
}
