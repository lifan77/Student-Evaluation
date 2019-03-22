package com.tangcoo.evaluation.pojo;

import lombok.Data;

import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "class")
public class Class {
    private Integer classId;

    private String name;

    private Integer teacherId;

    private Integer classTeacherId;

    private Integer gradeId;

    private Integer status;

    private Integer totalStu;

    private Date openTime;

}