package com.tangcco.evaluation.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tangcco.evaluation.service.PaperService;
import com.tangcco.evaluation.service.UserService;
import com.tangcoo.evaluation.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/student")
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PaperService paperService;
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
}
