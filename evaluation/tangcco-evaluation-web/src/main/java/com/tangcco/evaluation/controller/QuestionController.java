package com.tangcco.evaluation.controller;

import com.tangcco.evaluation.service.GradeService;
import com.tangcco.evaluation.service.QuestionService;
import com.tangcoo.evaluation.dto.Result;
import com.tangcoo.evaluation.pojo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequestMapping("/question")
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private GradeService gradeService;

    @RequestMapping("/questions")
    public String findAllByExample(Model model,Integer gradeId, Integer teacherType){
        gradeId=gradeId==null?1:gradeId;
        teacherType=teacherType==null?0:teacherType;
        model.addAttribute("questions",questionService.findAllByExample(gradeId,teacherType));
        model.addAttribute("grades",gradeService.findAll());
        model.addAttribute("gradeId",gradeId);
        model.addAttribute("teacherType",teacherType);
        return "questions";
    }
    @ResponseBody
    @RequestMapping("/delete")
    public Result delete(Question question){
        if(questionService.delete(question)>0){
            return new Result(true, "删除成功");
        } else {
            return new Result(false, "删除失败");
        }
    }

    @RequestMapping("savePage")
    public String savePage(Model model){
        model.addAttribute("grades",gradeService.findAll());
        return "add_question";
    }

    @RequestMapping("setPage")
    public String setPage(Model model,Integer questionId){
        Question question = new Question();
        question.setQuestionId(questionId);
        model.addAttribute("question",questionService.findOne(question));
        model.addAttribute("grades",gradeService.findAll());
        return "set_question";
    }

    @ResponseBody
    @RequestMapping("save")
    public Result save(Question question,String time){
        if(question.getQuestionId() == null){
            question.setCreateTime(new Date());
            if(questionService.insert(question)>0){
                return new Result(true, "添加成功");
            } else {
                return new Result(false, "添加失败");
            }
        }else{
            try {
                SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                question.setCreateTime(format.parse(time));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            question.setUpdateTime(new Date());
            if(questionService.update(question)>0){
                return new Result(true, "修改成功");
            } else {
                return new Result(false, "修改失败");
            }
        }
    }
}
