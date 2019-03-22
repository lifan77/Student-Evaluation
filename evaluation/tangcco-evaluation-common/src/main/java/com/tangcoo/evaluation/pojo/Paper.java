package com.tangcoo.evaluation.pojo;

import lombok.Data;

import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "paper")
public class Paper {
    private Integer paperId;

    private String title;

    private String direction;

    private String classes;

    private Integer teacherType;

    private Date createTime;

    private Date beginTime;

    private Date endTime;

}