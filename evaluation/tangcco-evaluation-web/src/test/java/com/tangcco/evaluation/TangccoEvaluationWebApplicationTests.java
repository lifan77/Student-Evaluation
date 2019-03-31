package com.tangcco.evaluation;

import com.tangcco.evaluation.dao.ClassMapper;
import com.tangcco.evaluation.service.ClassService;
import com.tangcco.evaluation.service.GradeService;
import com.tangcco.evaluation.service.TeacherService;
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
    private TeacherService teacherService;
    @Autowired
    private ClassMapper classMapper;
    @Autowired
    private GradeService gradeService;
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

    }
    @Test
    public void classTest(){
        //测试班级列表

     PageDto<Class> classPageDto = classService.selectClassByClassGrade(1,5,"",null);
        System.out.println(classPageDto.getData());
    }

    @Test
    public void testDetail(){
     /*  PageDto<User> userPageDto = userService.selectUser(1,2,3,"李");
        System.out.println("123434567"+userPageDto.getData().size());
       for (User user : userPageDto.getData()){
            System.out.println("user的数据是哈哈："+user+"============"+"总数："+userPageDto.getTotal()+"每页的数量"+userPageDto.getPageSize());
        }
        //System.out.println(userPageDto.getTotal()+"pageSize"+userPageDto.getPageSize());*/

     List <Class> classList = classService.queryAllClassByGid(1);
        System.out.println(classList+"ssssssssssss");
    }
}
