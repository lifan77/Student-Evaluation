package com.tangcco.evaluation.service;

import com.tangcoo.evaluation.pojo.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findAllByExample(Integer gradeId,Integer teacherType);

    int delete(Question question);

    int insert(Question question);

    int update(Question question);

    Question findOne(Question question);
}
