package com.tangcco.evaluation.service;

import com.tangcoo.evaluation.pojo.Answer;

import java.util.List;
import java.util.Map;

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


    /**
     * 本月共测评次数(以日为单位,每日的测评班级算在一次测评中)
     * cuixiaojian
     * 3/24
     * */
    Integer queryCount();
    //查询教师月排名
    List<Map> queryTeacherOrderList(String status);
    //查询教师总排名
    List<Map> queryAllTeacherOrderList(String status);
    //根据查询教师姓名
    String queryTeacherName(Integer teacherId);
    //查询意见
    List<Map> queryTeacherOpinion(Integer teacherId,Integer Top);
    //查询反馈条数修改HTML元素
    Integer queryTeacherOpinionCount(Integer teacherId);
    //根据老师id与当前月份查询平均分
    List<Map> queryTeacherAVGById(Integer teacherId);
    Map<String,Integer> queryJsonById(Integer teacherId);
    Map<String,String> queryPM(Integer teacherId);
    List<Answer> findAnswer(Integer cid,Integer pid);

    Integer avgAnswerScore(Integer cid, Integer pid);

    Answer getAnswerDetail(Integer aid);

}
