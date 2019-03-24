package com.tangcco.evaluation.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tangcco.evaluation.service.PaperService;
import com.tangcco.evaluation.service.QuestionService;
import com.tangcco.evaluation.service.UserService;
import com.tangcoo.evaluation.pojo.Question;
import com.tangcoo.evaluation.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/student")
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PaperService paperService;
    @Autowired
    private QuestionService questionService;
    @RequestMapping("")
    public String index(Model model){
        Map<String,String> map=new HashMap<>();
        for (int i = 0; i < paperService.findJson().size(); i++) {
            String jsonArray = paperService.findJson().get(i).getClasses();//获取到两个json的String
            JSONArray list = JSON.parseArray(jsonArray);//String转成JSONArray
            System.out.println(list.size());

            for (int j = 0; j < list.size(); j++) {
                // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                JSONObject job = list.getJSONObject(j);
                // 得到 每个对象中的属性值
                //System.out.println(job.get("classId") + "=");
                map.put(job.get("classId").toString(),job.get("name").toString());
                //System.out.println(job.get("name") + "=");
            }

        }
        model.addAttribute("map",map);
        System.out.println(map);
        return "/admin-login/index";
    }

    @RequestMapping(value = "studentLogin",method = RequestMethod.POST)
    public Boolean loginStudent(String password,String name,Integer classId){
        User user=new User();
        user.setClassId(classId);
        //user.setLand(1);
        user.setName(name);
        String yan=password;
        User user1=userService.login(user);
        String seng=user1.getNumber().substring(12,18);//获取后六位
        Integer land=user1.getLand();//获取登录状态
        //登录状态判断
        if(land==1){
            System.out.println("允许登录");
            if(seng.equals(yan)){
                System.out.println("验证成功");
                return true;
            }else{
                System.out.println("验证失败");
                return false;
            }
        }else{
            System.out.println("不允许登录");
            return false;
        }
    }
    @RequestMapping("exam")
    public String exam(Model model) {  //Integer gradeId,Integer teacherType 这两个参数一定要加的
        Question t = new Question();
        t.setGradeId(1);
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


}
