package com.tangcoo.evaluation.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "answer")
public class Answer {
    @Id
    private Integer answerId;

    private String nickname;

    private String detail;

    private Integer totalScore;

    private String opinion;

    private Date createTime;

    private Integer status;

    private Integer classId;

    private Integer teacherId;

    private Integer paperId;

    private String course;
}