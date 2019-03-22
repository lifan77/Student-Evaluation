package com.tangcco;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.tangcco.evaluation.dao"})
public class TangccoEvaluationWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TangccoEvaluationWebApplication.class, args);
    }

}
