package com.tangcco.evaluation;

import com.tangcco.evaluation.service.UserService;
import com.tangcoo.evaluation.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    @Test
    public void contextLoads() {
        User user=new User();
        user.setClassId(1);
        user.setLand(1);
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
}
