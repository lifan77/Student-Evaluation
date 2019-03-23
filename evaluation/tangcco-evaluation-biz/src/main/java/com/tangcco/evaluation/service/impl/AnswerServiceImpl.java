package com.tangcco.evaluation.service.impl;

import com.tangcco.evaluation.dao.AnswerMapper;
import com.tangcco.evaluation.service.AnswerService;
import com.tangcoo.evaluation.pojo.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerMapper answerMapper;
    /**
    * @Description: 用来登录使用的
    *@Param: []
    * @return: java.util.List<com.tangcoo.evaluation.pojo.Answer>
    * @Author: ShiDunKai
    * @Date: 2019/3/23
    */
    @Override
    public List<Answer> queryAnswerId() {
        return answerMapper.selectAll();
    }
}
