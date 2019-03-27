package com.tangcco.evaluation.service;

import com.tangcoo.evaluation.pojo.Answer;

import java.util.List;

public interface AnswerService {

    /** 
    * @Description: 用来登录使用的 
    * @Param: [] 
    * @return: java.util.List<com.tangcoo.evaluation.pojo.Answer> 
    * @Author: ShiDunKai 
    * @Date: 2019/3/23 
    */ 
    List<Answer> queryAnswerId();
    Integer addAnswer(Answer answer);
}
