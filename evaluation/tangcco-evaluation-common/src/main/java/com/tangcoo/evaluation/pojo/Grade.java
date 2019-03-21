package com.tangcoo.evaluation.pojo;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "grade")
public class Grade {
    private Integer gradeId;

    private String name;

    private Integer duration;


}