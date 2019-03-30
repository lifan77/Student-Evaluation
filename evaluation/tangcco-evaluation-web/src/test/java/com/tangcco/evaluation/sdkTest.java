package com.tangcco.evaluation;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tangcco.evaluation.service.*;
import com.tangcoo.evaluation.pojo.*;
import com.tangcoo.evaluation.pojo.Class;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * @program: 史敦凯的测试类
 * @description: ${description}
 * @author: ShiDunKai
 * @create: 2019-03-22 16:44
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class sdkTest {
    /**
     * @Description: 测试登录
     * @Param: []
     * @return: void
     * @Author: ShiDunKai
     * @Date: 2019/3/22
     */
    @Autowired
    private UserService userService;
    @Autowired
    private ClassService classService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private PaperService paperService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private TeacherService teacherService;
    @Test
    public void contextLoads() {
        User user=new User();
        user.setClassId(1);
        //user.setLand(1);
        user.setName("学生2");

        String yan="283613";
        String seng=userService.login(user).getNumber().substring(12,18);
        System.out.println(seng);
        if(seng.equals(yan)){
            System.out.println("验证成功");
        }else{
            System.out.println("陈江虹好傻");
            System.out.println("验证失败");
        }
    }
    @Test
    public void testQuestion(){
        Question t=new Question();
        t.setGradeId(1);
        t.setTeacherType(1);
        List<Question> q=questionService.selectQuestion(t);//根据年级，教员开始分配题目
        //[Question(questionId=2, title=测试2, direction=很棒, options=[{"detail":"这是第一个选项","score":"1"},{"detail":"这是第二个选项","score":"2"},{"detail":"这是第三个选项","score":"3"}], gradeId=1, createTime=Sat Mar 23 14:32:31 CST 2019, updateTime=Sat Mar 23 19:32:36 CST 2019, teacherType=2)]
        /*List<String> key=new ArrayList<>();
        List<String> value=new ArrayList<>();*/
        Map<Integer,Map> map=new HashMap<>();
        for (int i = 0; i <q.size() ; i++) {
             Integer xuhao=q.get(i).getQuestionId();
            System.out.println(q.get(i).getOptions());//得到array
            String jsonArray=q.get(i).getOptions();
            JSONArray list = JSON.parseArray(jsonArray);
            List<String> key=new ArrayList<>();
            List<String> value=new ArrayList<>();
            Map<String,String> option=new HashMap<>();
            for (int j = 0; j < list.size(); j++) {
                // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                JSONObject job = list.getJSONObject(j);
                // 得到 每个对象中的属性值
                System.out.println(job.get("detail") + "=");
                option.put(job.get("detail").toString(),job.get("score").toString());
                //System.out.println(option);
                //key.set(j,job.get("detail").toString());
                //value.set(j,job.get("score").toString());
                //map.put(key,value);
                //System.out.println(job.get("name") + "=");
            }
            map.put(xuhao,option);
        }
        System.out.println(map);
        //这是往前面传的结果
        //{1={这是第二个选项=2, 这是第一个选项=1, 这是第三个选项=3}, 2={这是第二个选项=2, 这是第一个选项=1, 这是第三个选项=3}}
    }

    @Test
    public void testClassAll(){
        Class c=new Class();
        c.setClassId(1);
        System.out.println(classService.select(c));
       /* System.out.println(classService.select().size());
        System.out.println(classService.select().get(0));
        System.out.println(classService.select().get(0).getName());*/
        List<Integer> list=new ArrayList<>();
       /* for (int i=0;i<classService.select().size();i++) {
            String name=classService.select().get(i).getName();
            list.add(i,name);
            //System.out.println(i);
        }*/

       //废物测试，查了一个根本不需要的功能
       /* for (int i = 0; i <answerService.queryAnswerId().size() ; i++) {
            list.add(answerService.queryAnswerId().get(i).getClassId());
        }
        System.out.println(list);*/
    }
    @Test
    public void findJson() {
        //{"teacherName":"crystall","teacherAge":27,"course":{"courseName":"english","code":1270},"students":[{"studentName":"lily","studentAge":12},{"studentName":"lucy","studentAge":15}]}"
        //System.out.println(paperService.findJson());
        /*List<Object> json=new ArrayList<>();*/
        // for (int i = 0; i <paperService.findJson().size() ; i++) {
        //System.out.println(paperService.findJson().get(i).getClasses());

        //JSONArray jsonArray=jsonObject.getJSONArray(jsonObject);
        Map<String,String> map=new HashMap<>();
        for (int i = 0; i < paperService.findJson().size(); i++) {
            JSONObject jsonObject=JSONObject.parseObject(paperService.findJson().get(i).getClasses());
            JSONArray list=jsonObject.getJSONArray("classes");

            /*String jsonArray = paperService.findJson().get(i).getClasses();//获取到两个json的String
            JSONArray list = JSON.parseArray(jsonArray);//String转成JSONArray
            System.out.println(list.size());*/

            for (int j = 0; j < list.size(); j++) {
                // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                JSONObject job = list.getJSONObject(j);
                // 得到 每个对象中的属性值
                //System.out.println(job.get("classId") + "=");
                map.put(job.get("classId").toString(),job.get("name").toString());
                //System.out.println(job.get("name") + "=");
            }

            //System.out.println(jsonObject);
        }
        System.out.println(map);

    }
    @Test
    public void submitExam1(){
        Answer answer=new Answer();
        answer.setNickname("小混蛋");
        answer.setDetail("[{'id':1,'wenti':'这是第一题的内容','daan':5},{'id':2,'wenti':'这是第二题的内容','daan':4},{'id':3,'wenti':'这是第三题的内容','daan':5}]");
        answer.setTotalScore(12);
        answer.setOpinion("啦啦啦啦");
        answer.setStatus(0);
        answer.setTeacherId(1);
        answer.setClassId(1);
        answer.setCreateTime(new Date());
        answer.setPaperId(1);
        System.out.println(answerService.addAnswer(answer));
    }

    @Test
    public void testQuery(){
        Date date=new Date();
        Integer garderId=0;
        List<Paper> p=paperService.findJson();
        for (int i = 0; i <p.size() ; i++) {
            if(date.getTime()<p.get(i).getEndTime().getTime()){
                System.out.println(p.get(i).getPaperId());
            }
        }
    }
    @Test
    public void testUpdate(){
        System.out.println(userService.userLand(1));
    }
    @Test
    public void testQueryTeacher(){
        System.out.println(teacherService.findTeacherById(1));
    }
}
