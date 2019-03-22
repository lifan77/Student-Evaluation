package com.tangcco.evaluation;

import com.tangcco.evaluation.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TangccoEvaluationWebApplicationTests {

    @Autowired(required = true)
    private UserService userService;

    @Test
    public void contextLoads() {
      /*  List<User> users = userService.queryAll();
        for (User user : users) {
            System.out.println(user.getName() + "===================");
        }*/
    }

}
