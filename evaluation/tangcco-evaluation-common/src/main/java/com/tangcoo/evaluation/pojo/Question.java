package com.tangcoo.evaluation.pojo;

import lombok.Data;

import javax.persistence.Table;
import java.util.Date;
@Data
@Table(name = "question")
public class Question {
    private Integer questionId;

    private String title;

    private String direction;

    private String options;

    private Integer gradeId;

    private Date createTime;

    private Date updateTime;

    private Integer teacherType;


}