package com.tangcco.evaluation.service.impl;

import com.tangcco.evaluation.dao.QuestionMapper;
import com.tangcco.evaluation.service.QuestionService;
import com.tangcoo.evaluation.pojo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public int insert(Question question) {
        return questionMapper.insert(question);
    }

    @Override
    public Question findOne(Question question) {
        return questionMapper.selectOne(question);
    }

    @Override
    public int update(Question question) {
        Example example=new Example(Question.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("questionId",question.getQuestionId());
        return questionMapper.updateByExample(question,example);
    }

    @Override
    public List<Question> findAllByExample(Integer gradeId, Integer teacherType) {
        Example example=new Example(Question.class);
        Example.Criteria criteria = example.createCriteria();
        if(gradeId != null && gradeId != -1){
            criteria.andEqualTo("gradeId",gradeId);
        }
        if(teacherType != null && teacherType != -1){
            criteria.andEqualTo("teacherType",teacherType);
        }
        return questionMapper.selectByExample(example);
    }

    @Override
    public int delete(Question question) {
        return questionMapper.delete(question);
    }
}
