package com.tangcco.evaluation.service.impl;

import com.tangcco.evaluation.dao.GradeMapper;
import com.tangcco.evaluation.service.GradeService;
import com.tangcoo.evaluation.pojo.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public List<Grade> selectGradeList() {
        return gradeMapper.selectAll();
    }
    @Override
    public List<Grade> findAll() {
        return gradeMapper.selectAll();
    }
}
