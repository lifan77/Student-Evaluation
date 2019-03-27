package com.tangcco.evaluation.service.impl;

import com.alibaba.fastjson.JSON;
import com.tangcco.evaluation.dao.AnswerMapper;
import com.tangcco.evaluation.service.AnswerService;

import com.tangcoo.evaluation.dto.DetailJson;
import com.tangcoo.evaluation.pojo.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Integer addAnswer(Answer answer) {
        return answerMapper.insert(answer);
    }
    @Override
    public Integer queryCount() {
        String ThisMouthSub=new SimpleDateFormat("yyyy-MM-dd").format(new Date()).substring(0,7);
        return answerMapper.queryCount(ThisMouthSub);
    }

    @Override
    public List<Map> queryTeacherOrderList(String status) {
        String ThisMouthSub=new SimpleDateFormat("yyyy-MM-dd").format(new Date()).substring(0,7);
        return answerMapper.queryTeacherOrderList(ThisMouthSub,status);
    }

    @Override
    public List<Map> queryAllTeacherOrderList(String status) {
        return answerMapper.queryAllTeacherOrderList(status);
    }

    @Override
    public String queryTeacherName(Integer teacherId) {
        return answerMapper.queryTeacherName(teacherId);
    }

    @Override
    public List<Map> queryTeacherOpinion(Integer teacherId,Integer Top) {
        return answerMapper.queryTeacherOpinion(teacherId,Top);
    }

    @Override
    public Integer queryTeacherOpinionCount(Integer teacherId) {
        return answerMapper.queryTeacherOpinionCount(teacherId);
    }

    @Override
    public List<Map> queryTeacherAVGById(Integer teacherId) {
        String ThisMouthSub=new SimpleDateFormat("yyyy-MM-dd").format(new Date()).substring(0,7);
        return answerMapper.queryTeacherAVGById(teacherId,ThisMouthSub);
    }

    @Override
    public Map<String,Integer> queryJsonById(Integer teacherId) {
        String ThisMouthSub=new SimpleDateFormat("yyyy-MM-dd").format(new Date()).substring(0,7);
        List<String> listStr=answerMapper.queryJsonById(teacherId,ThisMouthSub);
        int daan1=0,daan2=0,daan3=0,daan4=0,daan5=0;
        for(int i=0;i<listStr.size();i++){
            List<DetailJson> detailJsons= JSON.parseArray(listStr.get(i), DetailJson.class);
            for(int j=0;j<detailJsons.size();j++){
                int daan=detailJsons.get(j).getDaan();
                switch (daan){
                    case 1:
                        daan1++;
                        break;
                    case 2:
                        daan2++;
                        break;
                    case 3:
                        daan3++;
                        break;
                    case 4:
                        daan4++;
                        break;
                    case 5:
                        daan5++;
                        break;
                }
            }
        }
        Map<String,Integer> map=new HashMap<>();
        map.put("daan1",daan1);map.put("daan2",daan2);map.put("daan3",daan3);map.put("daan4",daan4);map.put("daan5",daan5);
        return map;
    }

    @Override
    public Map<String,String> queryPM(Integer teacherId) {
        String ThisMouthSub=new SimpleDateFormat("yyyy-MM-dd").format(new Date()).substring(0,7);
        List<Map> mapList=answerMapper.queryPM(ThisMouthSub);
        String rank="";
        String score="";
        for(int i=0;i<mapList.size();i++){
            if(teacherId==Integer.parseInt(mapList.get(i).get("teacher_id").toString())){
                score=mapList.get(i).get("score").toString();
                rank=(i+1)+"";
            }
        }
        Map<String,String> map=new HashMap<>();
        map.put("score",score);
        map.put("rank",rank);
        return map;
    }
}
