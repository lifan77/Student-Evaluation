package com.tangcoo.evaluation.pojo;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "teacher")
public class Teacher {
    private Integer teacherId;

    private String name;

    private Integer type;


}