package com.tangcco.evaluation.service;

import com.tangcoo.evaluation.pojo.Grade;

import java.util.List;

public interface GradeService {
    /**
     * @author:lifan
     * @deprecated : 查询所有班级类型
     * @return
     */
    List<Grade> selectGradeList();
    List<Grade> findAll();
}
