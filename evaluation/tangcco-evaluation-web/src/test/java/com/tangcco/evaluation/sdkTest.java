package com.tangcco.evaluation;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tangcco.evaluation.service.AnswerService;
import com.tangcco.evaluation.service.ClassService;
import com.tangcco.evaluation.service.PaperService;
import com.tangcco.evaluation.service.UserService;
import com.tangcoo.evaluation.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void testClassAll(){
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
        //System.out.println(paperService.findJson());
        /*List<Object> json=new ArrayList<>();*/
        // for (int i = 0; i <paperService.findJson().size() ; i++) {
        //System.out.println(paperService.findJson().get(i).getClasses());
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
        System.out.println(map);

    }
}
