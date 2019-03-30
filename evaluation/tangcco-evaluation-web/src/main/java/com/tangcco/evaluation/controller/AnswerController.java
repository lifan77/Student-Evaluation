package com.tangcco.evaluation.controller;

import com.alibaba.fastjson.JSON;
import com.tangcco.evaluation.service.AnswerService;
import com.tangcco.evaluation.service.ClassService;
import com.tangcoo.evaluation.pojo.Answer;
import com.tangcoo.evaluation.pojo.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AnswerController {

    @Resource
    AnswerService answerService;
    /**
     * 查询月评测次数
     * 崔笑健
     * 2019-03-24
     * */
    @CrossOrigin
    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
    @PostMapping("getTeacherAVGById")
    public List<Map> queryTeacherAVGById(@RequestParam("teacherId")String teacherId){
        return answerService.queryTeacherAVGById(Integer.parseInt(teacherId));
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("getJsonById")
    public Map<String,Integer> getJsonById(@RequestParam("teacherId")String teacherId){
        return answerService.queryJsonById(Integer.parseInt(teacherId));
    }
    @CrossOrigin
    @ResponseBody
    @PostMapping("getPM")
    public Map<String,String> getPM(@RequestParam("teacherId")String teacherId){
        return answerService.queryPM(Integer.parseInt(teacherId));
    }


    @Resource
    private ClassService classService;



    @RequestMapping("toAnswerList")
    @ResponseBody
    public JSON toAnswerList(@RequestParam(value = "cid", required = false) Integer cid, @RequestParam(value = "pid", required = false) Integer pid) {
        List<Answer> AnswerList = answerService.findAnswer(cid, pid);
        Integer avgScore=answerService.avgAnswerScore(cid,pid);

        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("list",AnswerList);
        resultMap.put("avgScore",avgScore);
        return (JSON) JSON.toJSON(resultMap);
    }

    @RequestMapping("getAnswerDetail")
    public String getAnswerDetail(Integer cid, Integer pid, Integer aid, Integer tid, Model model){
        Answer answer=answerService.getAnswerDetail(aid);
        model.addAttribute("detail",JSON.parseArray(answer.getDetail()));
        model.addAttribute("pid",pid);
        model.addAttribute("cid",cid);
        return "testScoreDetail";
    }

    @ResponseBody
    @RequestMapping("getTeacher")
    public Teacher getTeacher(Integer tid){
        return classService.getTeacher2(tid);
    }

}
