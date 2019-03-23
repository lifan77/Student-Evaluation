package com.tangcoo.evaluation.pojo;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "user")
public class User {
    private Integer userId;

    private String name;

    private Integer classId;

    private Integer land;

    private String number;

    private String password;
}