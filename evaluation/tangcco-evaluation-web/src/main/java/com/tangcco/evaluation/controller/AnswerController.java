package com.tangcco.evaluation.controller;

import com.tangcco.evaluation.service.AnswerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class AnswerController {

    @Resource
    AnswerService answerService;
    /**
     * 查询月评测次数
     * 崔笑健
     * 2019-03-24
     * */
    @CrossOrigin
    @PostMapping("getMouthCount")
    public Integer getMouthCount(){
        return answerService.queryCount();
    }
    /**
     * 查询月排名
     * 崔笑健
     * 2019-03-24
     * */
    @CrossOrigin
    @PostMapping("getTeacherAndAVG")
    public List<Map> getTeacherAndAVG(@RequestParam("status")String status){
        return answerService.queryTeacherOrderList(status);
    }
    /**
     * 查询总排名
     * 崔笑健
     * 2019-03-24
     * */
    @CrossOrigin
    @PostMapping("getAllTeacherAndAVG")
    public List<Map> getAllTeacherAndAVG(@RequestParam("status")String status){
        return answerService.queryAllTeacherOrderList(status);
    }
    /**
     * 根据ID查询教师姓名
     * 崔笑健
     * 2019-03-24
     * */
    @CrossOrigin
    @PostMapping("getTeacherName")
    public String getTeacherName(@RequestParam("teacherId")String teacherId){
        return answerService.queryTeacherName(Integer.parseInt(teacherId));
    }
    /**
     * 查询意见反馈
     * 崔笑健
     * 2019-03-24
     * */
    @CrossOrigin
    @PostMapping("getTeacherOpinion")
    public List<Map> getTeacherOpinion(@RequestParam("teacherId")String teacherId,@RequestParam("top")String Top){
        return answerService.queryTeacherOpinion(Integer.parseInt(teacherId),Integer.parseInt(Top));
    }
    /**
     * 查询反馈条数修改HTML元素
     * 崔笑健
     * 2019-03-24
     * */
    @CrossOrigin
    @PostMapping("getTeacherOpinionCount")
    public Integer getTeacherOpinionCount(@RequestParam("teacherId")String teacherId){
        return answerService.queryTeacherOpinionCount(Integer.parseInt(teacherId));
    }
    /**
     * 根据老师id与当前月份查询平均分
     * 崔笑健
     * 2019-03-24
     * */
    @CrossOrigin
    @PostMapping("getTeacherAVGById")
    public List<Map> queryTeacherAVGById(@RequestParam("teacherId")String teacherId){
        return answerService.queryTeacherAVGById(Integer.parseInt(teacherId));
    }

    @CrossOrigin
    @PostMapping("getJsonById")
    public Map<String,Integer> getJsonById(@RequestParam("teacherId")String teacherId){
        return answerService.queryJsonById(Integer.parseInt(teacherId));
    }
    @CrossOrigin
    @PostMapping("getPM")
    public Map<String,String> getPM(@RequestParam("teacherId")String teacherId){
        return answerService.queryPM(Integer.parseInt(teacherId));
    }
}
