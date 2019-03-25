package com.tangcoo.evaluation.dto;

import lombok.Data;

import java.util.List;


@Data
public class PageDto<T> {
   //总条数
    private Long total;
    //当前页码, 从1开始
    private Integer pageNo;
   //每页的最大数量，不是data集合的长度
    private Integer pageSize;
    //总页数
    private Integer pages;
   //当前页的数据集合
    private List<T> data;
}
