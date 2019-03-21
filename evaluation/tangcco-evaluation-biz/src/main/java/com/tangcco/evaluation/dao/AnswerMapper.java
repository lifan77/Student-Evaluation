package com.tangcco.evaluation.dao;

import com.tangcoo.evaluation.pojo.Answer;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author :lifan
 * @deprecated :answer的数据操作层
 *
 */
@org.apache.ibatis.annotations.Mapper
@Component
public interface AnswerMapper extends Mapper<Answer> {

}