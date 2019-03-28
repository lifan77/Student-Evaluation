package com.tangcco.evaluation.dao;

import com.tangcoo.evaluation.pojo.Answer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author :lifan
 * @deprecated :answer的数据操作层
 */
@org.apache.ibatis.annotations.Mapper
@Component
public interface AnswerMapper extends Mapper<Answer> {
    //查询本月测评共几日
    Integer queryCount(@Param("mouth") String mouth);

    //查询教师id，姓名以及平均分
    List<Map> queryTeacherOrderList(@Param("mouth")String mouth,@Param("status")String status);

    //总排名
    List<Map> queryAllTeacherOrderList(@Param("status")String status);

    //根据教师id查询教师姓名
    String queryTeacherName(@Param("teacherId")Integer teacherId);

    //查询意见反馈
    List<Map> queryTeacherOpinion(@Param("teacherId")Integer teacherId,@Param("top")Integer Top);

    //查询反馈条数修改HTML元素
    Integer queryTeacherOpinionCount(@Param("teacherId")Integer teacherId);

    //根据老师id与月份查询平均分
    List<Map> queryTeacherAVGById(@Param("teacherId")Integer teacherId,@Param("createTime")String mouth);

    List<String> queryJsonById(@Param("teacherId")Integer teacherId,@Param("mouth")String mouth);
    List<Map> queryPM(@Param("mouth")String mouth);
    List<Answer> getAnswer(@Param("cid")Integer cid, @Param("pid")Integer pid);

    Integer avgAnswerScore(@Param("cid")Integer cid, @Param("pid")Integer pid,@Param("minCount")Integer minCount,@Param("maxCount")Integer maxCount);

    Answer getAnswerDetail(Integer aid);

    Integer maxScoreCount(@Param("cid")Integer cid,@Param("pid")Integer pid);

    Integer minScoreCount(@Param("cid")Integer cid,@Param("pid")Integer pid);

}