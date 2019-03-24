package com.tangcco.evaluation;

import com.tangcco.evaluation.dao.ClassMapper;
import com.tangcco.evaluation.service.ClassService;
import com.tangcco.evaluation.service.UserService;
import com.tangcoo.evaluation.dto.PageDto;
import com.tangcoo.evaluation.pojo.Class;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TangccoEvaluationWebApplicationTests {

   /* @Autowired(required = true)
    private UserService userService;*/

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
    private ClassMapper classMapper;
    @Test
    public void contextLoads() {
        /*User user=new User();
        user.setClassId(1);
        user.setLand(1);
        String yan="283613";
        String seng=userService.login(user).getNumber().substring(12,18);
        System.out.println(seng);
        if(seng.equals(yan)){
            System.out.println("验证成功");
        }else{
            System.out.println("验证失败");
        }*/
        //测试班级列表
       PageDto<Class> classes = classService.selectClassByClassGrade(1,3,"TCMP067","AccpS1");
       List<Class> classList = classes.getData();
       for (Class c : classList){
           System.out.println(c.getName()+c.getClassTeacherId()+"===================================");
       }
    }
    @Test
    public void classTest(){
       Integer count = classService.getClassCount("TCMP067","Accp-S1");
        System.out.println("==========="+count);

    }
}
