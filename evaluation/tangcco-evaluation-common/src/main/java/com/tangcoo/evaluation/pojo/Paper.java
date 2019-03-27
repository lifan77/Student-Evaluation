package com.tangcoo.evaluation.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "paper")
public class Paper {
    private Integer paperId;

    private String title;

    private String direction;

    private Integer gradeId;

    private String classes;

    private Integer teacherType;

    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date beginTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endTime;

}