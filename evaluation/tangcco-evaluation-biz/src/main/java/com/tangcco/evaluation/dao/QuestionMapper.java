package com.tangcco.evaluation.dao;

import com.tangcoo.evaluation.pojo.Question;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@Component
public interface QuestionMapper extends Mapper<Question> {
}