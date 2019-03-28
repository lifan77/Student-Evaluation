package com.tangcco.evaluation.controller;

import com.alibaba.fastjson.JSON;
import com.tangcco.evaluation.service.AnswerService;
import com.tangcco.evaluation.service.ClassService;
import com.tangcco.evaluation.service.GradeService;
import com.tangcco.evaluation.service.TeacherService;
import com.tangcoo.evaluation.dto.PageDto;
import com.tangcoo.evaluation.pojo.Answer;
import com.tangcoo.evaluation.pojo.Class;
import com.tangcoo.evaluation.pojo.Grade;
import com.tangcoo.evaluation.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/class")
@Controller
public class ClassController {
    @Autowired
    private ClassService classService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("ClassList")
    public String ClassList( String className, Integer gradeId,Map map){
        System.out.println(className+gradeId+"============");
        PageDto<Class> classPageDto = classService.selectClassByClassGrade(1,10,className,gradeId);
        List<Grade> gradeList = gradeService.selectGradeList();
        map.put("grades",gradeList);
        map.put("classes",classPageDto);
        return "class/class_list";
    }

    @RequestMapping("ajaxClassList")
    @ResponseBody
    public Object ajaxClassList(Integer pageNo, Integer pageSize, String className, Integer gradeId){
        System.out.println(pageNo);
        PageDto<Class> classPageDto = classService.selectClassByClassGrade(pageNo,10,className,gradeId);
        return classPageDto;
    }

    @RequestMapping("addClass")
    public String addClass(Map map){
        List<Grade> gradeList = gradeService.selectGradeList();
        map.put("grades",gradeList);
        //查询type为1的班主任老师
        Teacher teacher = new Teacher();
        teacher.setType(1);
        List<Teacher> teacherList = teacherService.selectTeacherById(teacher);
        map.put("teacher",teacherList);
        //查询type为2的教员老师
        Teacher classTescher = new Teacher();
        classTescher.setType(0);
        List<Teacher> classTeacherList = teacherService.selectTeacherByclassTeacher(classTescher);
        map.put("classTeacher",classTeacherList);
        return "class/add_class";
    }

    @RequestMapping("addClasses")
    public String addClasses(Map map, String className, Integer classType, Integer teacherId,
                             Integer classTeacherId, Integer classNum, String classDate){
        Class c = new Class();
        c.setName(className);
        c.setGradeId(classType);
        c.setTeacherId(teacherId);
        c.setClassTeacherId(classTeacherId);
        c.setTotalStu(classNum);
        c.setStatus(0);
        //date转换Stirng
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            c.setOpenTime(simpleDateFormat.parse(classDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Integer count = classService.addClass(c);
        if(count > 0){
            return "redirect:/ClassList";
        }else {
            map.put("msg","新增班级失败");
            return "class/add_class";
        }
    }


    @RequestMapping("classDetail")
    public String classDetail(Integer classId,Map map){
        System.out.println("进入controlle");
        System.out.println("0000000000000000000000"+classId);
        Class c = classService.selectClassById(classId);
        System.out.println("陈江红我死了吗"+c+"=========================");
        map.put("class",c);
        return "class/classDetail";
    }

    @RequestMapping("updateClass")
    public String updateClass(Map map,Integer classId){
        List<Grade> gradeList = gradeService.selectGradeList();
        map.put("grades",gradeList);
        //查询type为1的班主任老师
        Teacher teacher = new Teacher();
        teacher.setType(1);
        List<Teacher> teacherList = teacherService.selectTeacherById(teacher);
        map.put("teacher",teacherList);
        //查询type为2的教员老师
        Teacher classTescher = new Teacher();
        classTescher.setType(0);
        List<Teacher> classTeacherList = teacherService.selectTeacherByclassTeacher(classTescher);
        map.put("classTeacher",classTeacherList);
        Class c = classService.selectClassById(classId);
        map.put("class",c);
        return "class/update_class";
    }


    @RequestMapping("updateClasses")
    public String updateClasses(Map map,Integer classId,String className,Integer classType,Integer teacherId,Integer classTeacherId,Integer classNum,Integer classStatus,String classDate){
        Class c = classService.selectClassById(classId);
        c.setName(className);
        c.setGradeId(classType);
        c.setTeacherId(teacherId);
        c.setClassTeacherId(classTeacherId);
        c.setStatus(classStatus);
        c.setTotalStu(classNum);
        //date转换Stirng
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            c.setOpenTime(simpleDateFormat.parse(classDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Integer count = classService.updateClassById(c);
        if(count>0){
            return "redirect:/ClassList";
        }else{
            return "class/update_class";
        }
    }


    @RequestMapping("deleteClass")
    @ResponseBody
    public Boolean deleteClass(Integer classId,Map map) {
        Class c = classService.selectClassById(classId);
        c.setStatus(1);
        Integer count = classService.updateClassById(c);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }
    @ResponseBody
    @RequestMapping("/classes")
    public List<Class> clesses(Integer gradeId){
        return classService.findAllByExample(gradeId);
    }





    @Resource
    private AnswerService answerService;





    @RequestMapping("toAnswerList")
    @ResponseBody
    public JSON toAnswerList(@RequestParam(value = "cid", required = false) Integer cid, @RequestParam(value = "pid", required = false) Integer pid) {
        List<Answer> AnswerList = answerService.findAnswer(cid, pid);
        Integer avgScore=answerService.avgAnswerScore(cid,pid);

        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("list",AnswerList);
        resultMap.put("avgScore",avgScore);
        return (JSON) JSON.toJSON(resultMap);
    }

    @RequestMapping("getAnswerDetail")
    public String getAnswerDetail(Integer cid, Integer pid, Integer aid, Integer tid, Model model){
        Answer answer=answerService.getAnswerDetail(aid);
        model.addAttribute("detail",JSON.parseArray(answer.getDetail()));
        model.addAttribute("pid",pid);
        model.addAttribute("cid",cid);
        return "testScoreDetail";
    }

    @ResponseBody
    @RequestMapping("getTeacher")
    public Teacher getTeacher(@RequestParam(value = "tid",required = false) Integer tid){
        return classService.getTeacher2(tid);
    }


}
