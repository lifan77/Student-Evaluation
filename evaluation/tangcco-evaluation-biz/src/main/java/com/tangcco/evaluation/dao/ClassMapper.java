package com.tangcco.evaluation.dao;

import com.tangcoo.evaluation.pojo.Class;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@Component
public interface ClassMapper extends Mapper<Class> {

}