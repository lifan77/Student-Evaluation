package com.tangcco.evaluation.dao;

import com.tangcoo.evaluation.pojo.Paper;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@Component
public interface PaperMapper extends Mapper<Paper> {

}