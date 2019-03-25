package com.tangcco.evaluation.service;

import com.tangcoo.evaluation.pojo.Class;

import java.util.List;

public interface ClassService {
    List<Class> findAllByExample(Integer gradeId);
}
