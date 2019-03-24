package com.tangcco.evaluation.service.impl;

import com.tangcco.evaluation.dao.QuestionMapper;
import com.tangcco.evaluation.service.QuestionService;
import com.tangcoo.evaluation.pojo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Override
    public List<Question> selectQuestion(Question t) {
        return questionMapper.select(t);
    }
}
