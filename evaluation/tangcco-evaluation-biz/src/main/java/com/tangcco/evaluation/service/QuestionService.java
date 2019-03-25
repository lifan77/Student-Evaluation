package com.tangcco.evaluation.service;

import com.tangcoo.evaluation.pojo.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findAllByExample(Integer gradeId,Integer teacherType);

    int delete(Question question);

    int insert(Question question);

    int update(Question question);

    Question findOne(Question question);
    /**
    * @Description:  展示问题用
    * @Param: []
    * @return: java.util.List<com.tangcoo.evaluation.pojo.Question>
    * @Author: ShiDunKai
    * @Date: 2019/3/23
    */
    List<Question> selectQuestion(Question t);
}
