package com.tangcco.evaluation.service;

import com.tangcoo.evaluation.dto.PageDto;
import com.tangcoo.evaluation.pojo.Class;
import com.tangcoo.evaluation.pojo.Teacher;

import java.util.List;

public interface ClassService {
    List<Class> findAllByExample(Integer gradeId);
    /**
     * @Description: 查询答卷用
     * @Param:
     * @return:
     * @Author: ShiDunKai
     * @Date: 2019/3/22
     */
    List<Class> select(Class c);

    /**
     * @author:lifan
     * @param pageNo 页面
     * @param pageSize 页面数量
     * @param className 班级名称
     * @param gradeId  年级名称
     * @deprecated :根据年级名称或者班级名称模糊查询班级列表
     * @return
     */
      PageDto<Class> selectClassByClassGrade(Integer pageNo, Integer pageSize, String className, Integer gradeId);

    /**
     * @author:lifan
     * @param className 班级名称
     * @param gradeId 年级名称
     * @deprecated :查询班级总数量
     * @return
     */
    Integer getClassCount( String className,Integer gradeId);

    /**
     * @author:lifan
     * @deprecated :新增班级
     * @return
     */
    Integer addClass(Class c);
    /**
     * @author:lifan
     * @deprecated :修改班级
     * @return
     */
    Integer updateClass(Class c);

    /**
     * @author : lifan
     * @param classId 班级id
     * @deprecated : 根据id查询班级信息
     * @return
     */
    Class selectClassById(Integer classId);

    /**
     * @author: lifan
     * @param c
     * @deprecated : 根据id修改班级信息
     * @return
     */
    Integer updateClassById(Class c);
    public List<Class> findClassList();

    Class findClazz(Integer cid);

    List<Teacher> getTeacherList(Class clazz);

    Teacher getTeacher2(Integer tid);

    /**
     * @author : lifan
     * @deprecated : 根据年级查询班级信息
     * @return
     */
    List<Class> queryAllClassByGid(Integer gradeId);

    /**
     * @author:lifan
     * @deprecated : 查询所有班级
     * @return
     */
    List<Class> queryAll();

}
