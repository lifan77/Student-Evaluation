package com.tangcoo.evaluation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageResult<T> {
    private int total;// 总条数
    private int totalPage;// 总页数
    private List<T> items;// 当前页数据

    public PageResult(int total, List<T> items) {
        this.total = total;
        this.items = items;
    }

}