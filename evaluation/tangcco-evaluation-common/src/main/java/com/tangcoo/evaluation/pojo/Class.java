package com.tangcoo.evaluation.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Table;
import javax.persistence.Transient;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date openTime;
    @Transient
    private Grade grade;
    @Transient
    private Teacher teacher;
    @Transient
    private Teacher classTeacher;
}