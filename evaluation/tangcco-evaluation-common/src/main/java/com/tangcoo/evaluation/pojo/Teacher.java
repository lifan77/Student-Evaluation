package com.tangcoo.evaluation.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@Data
@Table(name = "teacher")
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private Integer teacherId;

    private String name;
    private String sname;


    private String tname;



    private Integer type;


}