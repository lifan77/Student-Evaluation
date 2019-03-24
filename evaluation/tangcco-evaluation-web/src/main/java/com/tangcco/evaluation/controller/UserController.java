package com.tangcco.evaluation.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tangcco.evaluation.service.*;
import com.tangcoo.evaluation.pojo.Answer;
import com.tangcoo.evaluation.pojo.Class;
import com.tangcoo.evaluation.pojo.Question;
import com.tangcoo.evaluation.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

@RequestMapping("/student")
@Controller
public class UserController {
    //先查出来paper表的状态，然后查出来班级
    private Integer paperId;
    private Date endTime;
    //根据班级查出teacherId，教员Id
    private Integer teacherId;
    private Integer classTeacherId;
    //获取班级id
    private Integer classId;
    //获取班级的所属年级
    private Integer gradeId;
    //意见反馈
    private String option;
    //昵称
    private String nickname;


    @Autowired
    private UserService userService;
    @Autowired
    private PaperService paperService;
    @Autowired
    private ClassService classService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;
    @RequestMapping("")
    public String index(Model model){
        Map<String,String> map=new HashMap<>();
        for (int i = 0; i < paperService.findJson().size(); i++) {
            JSONObject jsonObject = JSONObject.parseObject(paperService.findJson().get(i).getClasses());
            JSONArray list = jsonObject.getJSONArray("classes");

            /*String jsonArray = paperService.findJson().get(i).getClasses();//获取到两个json的String
            JSONArray list = JSON.parseArray(jsonArray);//String转成JSONArray
            System.out.println(list.size());*/

            for (int j = 0; j < list.size(); j++) {
                // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                JSONObject job = list.getJSONObject(j);
                // 得到 每个对象中的属性值
                //System.out.println(job.get("classId") + "=");
                map.put(job.get("classId").toString(), job.get("name").toString());
                //System.out.println(job.get("name") + "=");
            }
        }
        model.addAttribute("map",map);
        System.out.println(map);
        return "/admin-login/index";
    }

    @RequestMapping(value = "studentLogin",method = RequestMethod.POST)
    public String  loginStudent(String password,String name,Integer classId){
        User user=new User();
        user.setClassId(classId);
        this.classId=classId;   //33333333333333333333333333333333333333333333333333333333333333333333333333
        Class c=new Class();
        c.setClassId(this.classId);
        Class c2=classService.select(c).get(0);
        this.teacherId=c2.getTeacherId();//33333333333333333333333333333333333333333333333333333333333333333
        this.classTeacherId=c2.getClassTeacherId();//3333333333333333333333333333333333333333333333333333333
        this.gradeId=c2.getGradeId();
        //user.setLand(1);
        user.setName(name);
        String yan=password;
        User user1=userService.login(user);
        System.out.println(user1);
        String seng=user1.getNumber().substring(12,18);//获取后六位
        Integer land=user1.getLand();//获取登录状态
        //登录状态判断
        if(land==1){
            System.out.println("允许登录");
            if(seng.equals(yan)){
                System.out.println("验证成功");
                return "forward:/student/exam1";
            }else{
                System.out.println("验证失败");
                return "redirect:/student/studentLogin";
            }
        }else{
            System.out.println("不允许登录");
            return "redirect:/student/studentLogin";
        }
    }
    @RequestMapping("exam1")
    public String exam(Model model) {  //Integer gradeId,Integer teacherType 这两个参数一定要加的
        Question t = new Question();
        t.setGradeId(this.gradeId);
        t.setTeacherType(1);
        List<Question> q = questionService.selectQuestion(t);//根据年级，教员开始分配题目
        //[Question(questionId=2, title=测试2, direction=很棒, options=[{"detail":"这是第一个选项","score":"1"},{"detail":"这是第二个选项","score":"2"},{"detail":"这是第三个选项","score":"3"}], gradeId=1, createTime=Sat Mar 23 14:32:31 CST 2019, updateTime=Sat Mar 23 19:32:36 CST 2019, teacherType=2)]
        /*List<String> key=new ArrayList<>();
        List<String> value=new ArrayList<>();*/
        Map<String, Map> map = new HashMap<>();
        for (int i = 0; i < q.size(); i++) {
            String xuhao = q.get(i).getTitle();
            System.out.println(q.get(i).getOptions());//得到array
            String jsonArray = q.get(i).getOptions();
            JSONArray list = JSON.parseArray(jsonArray);
            List<String> key = new ArrayList<>();
            List<String> value = new ArrayList<>();
            Map<String, String> option = new HashMap<>();
            for (int j = 0; j < list.size(); j++) {
                // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                JSONObject job = list.getJSONObject(j);
                // 得到 每个对象中的属性值
                System.out.println(job.get("detail") + "=");
                option.put(job.get("detail").toString(), job.get("score").toString());
                //System.out.println(option);
                //key.set(j,job.get("detail").toString());
                //value.set(j,job.get("score").toString());
                //map.put(key,value);
                //System.out.println(job.get("name") + "=");
            }
            map.put(xuhao, option);
        }
        System.out.println(map);
        model.addAttribute("map",map);
        //这是往前面传的结果
        //{1={这是第二个选项=2, 这是第一个选项=1, 这是第三个选项=3}, 2={这是第二个选项=2, 这是第一个选项=1, 这是第三个选项=3}}
        return "/ans/demo";
    }
    @RequestMapping("exam2")
    public String exam2(Model model) {  //Integer gradeId,Integer teacherType 这两个参数一定要加的
        System.out.println("进来没有exam2");
        Question t = new Question();
        t.setGradeId(this.gradeId);
        t.setTeacherType(2);
        List<Question> q = questionService.selectQuestion(t);//根据年级，教员开始分配题目
        //[Question(questionId=2, title=测试2, direction=很棒, options=[{"detail":"这是第一个选项","score":"1"},{"detail":"这是第二个选项","score":"2"},{"detail":"这是第三个选项","score":"3"}], gradeId=1, createTime=Sat Mar 23 14:32:31 CST 2019, updateTime=Sat Mar 23 19:32:36 CST 2019, teacherType=2)]
        /*List<String> key=new ArrayList<>();
        List<String> value=new ArrayList<>();*/
        Map<String, Map> map = new HashMap<>();
        for (int i = 0; i < q.size(); i++) {
            String xuhao = q.get(i).getTitle();
            System.out.println(q.get(i).getOptions());//得到array
            String jsonArray = q.get(i).getOptions();
            JSONArray list = JSON.parseArray(jsonArray);
            List<String> key = new ArrayList<>();
            List<String> value = new ArrayList<>();
            Map<String, String> option = new HashMap<>();
            for (int j = 0; j < list.size(); j++) {
                // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                JSONObject job = list.getJSONObject(j);
                // 得到 每个对象中的属性值
                System.out.println(job.get("detail") + "=");
                option.put(job.get("detail").toString(), job.get("score").toString());
                //System.out.println(option);
                //key.set(j,job.get("detail").toString());
                //value.set(j,job.get("score").toString());
                //map.put(key,value);
                //System.out.println(job.get("name") + "=");
            }
            map.put(xuhao, option);
        }
        System.out.println(map);
        model.addAttribute("map",map);
        //这是往前面传的结果
        //{1={这是第二个选项=2, 这是第一个选项=1, 这是第三个选项=3}, 2={这是第二个选项=2, 这是第一个选项=1, 这是第三个选项=3}}
        return "/ans/demo2";
    }

    @RequestMapping("submitExam")
    public String submitExam1(String nickname,String detail,Integer score,String option){
        Answer answer=new Answer();
        answer.setNickname(nickname);
        System.out.println(detail);
        detail=detail.substring(0,detail.length() - 1);
        answer.setDetail("["+detail+"]");
        answer.setTotalScore(score);
        answer.setOpinion(option);
        answer.setStatus(0);
        answer.setTeacherId(this.teacherId);
        answer.setClassId(this.classId);
        answer.setPaperId(1);
        answer.setCreateTime(new Date());
        answerService.addAnswer(answer);
        System.out.println(nickname+""+detail+""+score+""+option);
        return "forward:/student/exam2";
    }
    @RequestMapping("submitExam2")
    public String submitExam2(String nickname,String detail,Integer score,String option){
        Answer answer=new Answer();
        answer.setNickname(nickname);
        detail=detail.substring(0,detail.length() - 1);
        answer.setDetail("["+detail+"]");
        answer.setTotalScore(score);
        answer.setOpinion(option);
        answer.setStatus(0);
        answer.setCreateTime(new Date());
        answer.setTeacherId(this.classTeacherId);
        answer.setClassId(this.classId);
        answerService.addAnswer(answer);
        return "/admin-login/index";
    }



}
