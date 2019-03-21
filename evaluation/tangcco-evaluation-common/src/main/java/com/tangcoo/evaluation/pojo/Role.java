package com.tangcoo.evaluation.pojo;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "role")
public class Role {
    private Integer roleId;

    private String password;

}