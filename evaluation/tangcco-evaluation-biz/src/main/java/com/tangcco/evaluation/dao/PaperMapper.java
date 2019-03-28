package com.tangcco.evaluation.dao;

import com.tangcoo.evaluation.pojo.Paper;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Component
public interface PaperMapper extends Mapper<Paper> {

    /**
     * 查询所有Paper表数据，用于下拉框展示
     * @return
     */
    List<Paper> getPaperList();

    /**
     * 根据ID查询CLasses
     * @param pid
     * @return
     */
    Paper getPaperClasses(Integer pid);

}